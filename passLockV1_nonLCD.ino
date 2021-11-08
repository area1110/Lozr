#include <Keypad.h>
#include <Servo.h>
#include <EEPROM.h>
#include <string.h>
#include <stdlib.h>

const byte ROWS = 4; 
const byte COLS = 4;
const short LED_1 = 13;
const short SERVO_PORT = 12;
const short SPEAKER = 11;
const short BTN = 2;
Servo servo;

char hexaKeys[ROWS][COLS] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte rowPins[ROWS] = {5, 4, A0, A1}; 
byte colPins[COLS] = {A2, A3, A4, A5}; 
Keypad keypad = Keypad(makeKeymap(hexaKeys), rowPins, colPins, ROWS, COLS); 

String password = "123456";
String passtemp = "";
short WrongpassTimes = 3; 
int disableTime = 10; //(s) time countdown when [wrongpasstime]times wrong password
char keyPressed;
int countFailed = 0;//count++ when provide wrong password
bool opened = false;
bool editMode = false;
bool systemLock = false; //Lock=true when provide
short timeToLock = 1000;
short countTimeLock = 0; //countup to close if opened


void blink(int led){
    digitalWrite(led, HIGH);
    delay(10);
    digitalWrite(led, LOW);
}

void beepError(int times){
  for(int i=0; i<times; i++){
    tone(SPEAKER, 100, 100);
    delay(300);
  }
}

void beepAlarm(int duration){
  tone(SPEAKER, 2000, duration);
}

void beepOpen(){
    tone(SPEAKER, 300, 200);
    delay(200);
    tone(SPEAKER, 900, 200);
    delay(200);
    tone(SPEAKER, 1800, 200);   
}

void beepClose(){
    tone(SPEAKER, 2000, 200);
    delay(200);
    tone(SPEAKER, 500, 200);
    delay(200);
    tone(SPEAKER, 900, 100);
}

 void doOpen(){
   opened = true;    
   passtemp = ""; //Clear string input for the next action
   countFailed = 0;
   countTimeLock = 0;
   keyPressed = 0;//Clear the key was pressed before;
   servo.write(0);
   beepOpen();   
 }

  void doClose(){     
    servo.write(135);
    opened = false;//reset to start the new cycle
    editMode = false;
    passtemp = "";  
    countTimeLock = 0;
    beepClose();  
 }
 void changeNewPassword(){   
  if(!editMode && keyPressed == '*'){
      beepOpen();
      passtemp = "";
      editMode = true;
      keyPressed = 0; 
    } else if(editMode && keyPressed == '#' ){     
      password = passtemp;
      writePassword(0, password);
      passtemp = "";
      editMode = false;
      Serial.println("newpass: " + password);        
      beepOpen();    
      doClose();       
    }
 }
 
void setup(){
  Serial.begin(9600);
  pinMode(BTN, INPUT_PULLUP);
  pinMode(LED_1, OUTPUT);
  servo.attach(SERVO_PORT, 500, 2500);
  Serial.begin(9600);
  if(EEPROM.read(0) != 0xFF){ // read data if available in EEPROM
    password = readPassword(0);
  }
  attachInterrupt(digitalPinToInterrupt(BTN), doClose, LOW);
  Serial.println( "pass:" + password);
}

void loop(){  
  if(!systemLock){
    keyPressed = keypad.getKey();
    if (keyPressed){ 
      beepAlarm(100);
      blink(LED_1);
      countTimeLock = 0; //if some key has been pressed, not close the door;
      if(keyPressed<='9' && keyPressed >='0'){        
        passtemp += keyPressed;       
      }
      if(keyPressed == 'D'){
        passtemp = "";
      }  
    } 
    if(opened) {
      if(editMode){
        blink(LED_1);
      }
      countTimeLock++;   
      changeNewPassword();
      if(keyPressed == 'C' || countTimeLock == timeToLock) {
        doClose();    
      }    
    } else {//the events when system close
        if(keyPressed == '#'){//confirm input
          if(passtemp.compareTo(password) == 0){ //Right pw
            doOpen();
          } else  {         
            passtemp = "";
            countFailed++;  
            beepError(countFailed);         
          }
        }
        if(countFailed == 4){
          beepError(5);
          systemLock = true;
          countFailed = 0;        
        }
        if(keyPressed == 'C') {   
          passtemp = "";
        }
        if(countTimeLock == timeToLock){
          passtemp = "";
          countTimeLock = 0;
        }   
     }
     if(passtemp.length() > 0){
        countTimeLock++;
     }
     //Serial.print(countTimeLock);
     keyPressed = 0;//clear key down temp at the end of loop
  } else {
    delay(disableTime * 1000);
    systemLock = false;
    beepAlarm(1000);
  }
  delay(15);
}

void writePassword(char address, String data){
  int size = data.length();
  int i;
  for(i=0; i<size; i++){
    EEPROM.write(address+i, data[i]);
  }
  EEPROM.write(address + size, '\0');   //Add termination null character for String Data
}


String readPassword(char address){
  char data[100]; //Max 100 Bytes
  int length=0;
  unsigned char tempChar;
  tempChar = EEPROM.read(address);
  while(tempChar != '\0' && length<100){       //Read until null character
    tempChar = EEPROM.read(address+length);
    data[length] = tempChar;
    length++;
  }
  data[length]='\0';
  return String(data);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.module;

import java.util.Random;

/**
 *
 * @author area1
 */
public class GenerateRandomString {

    public String GenerateRandomString() {
        int leftLimit = 64; // letter '@'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String buffer = new String();
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = random.nextInt(rightLimit - leftLimit) + leftLimit;
            buffer += ((char) randomLimitedInt);
        }
        return buffer;
    }
    
//    public static void main(String[] args) {
//        GenerateRandomString random = new GenerateRandomString();
//        System.out.println(random.GenerateRandomString());
//    }
}

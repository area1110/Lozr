function check_pass() {
  if (
    document.getElementById("password").value ===
    document.getElementById("repassword").value
  ) {
    document.getElementById("repassErr").style.display = "none";
    document.getElementById("submit").disabled = false;
  } else {
    document.getElementById("repassErr").style.display = "block";
    document.getElementById("submit").disabled = true;
  }
}

function removeSpace(){
  let input = document.getElementsByTagName("input");
     for (let eachInput of input) {
         eachInput.value = eachInput.value.trim();
     }
}

function display_error() {
  var errorLabel = document.getElementById("error");
  errorLabel.style.display = "none";
}

function checkSubmit() {
  const insertTitle = document.getElementById("insert-title");
  const submitTitle = document.getElementById("submit-title");
  insertTitle.value = insertTitle.value.trim();
  if (!insertTitle.value) {
    submitTitle.disabled = true;
  } else {
    submitTitle.disabled = false;
  }
}

function doReply(replyPostID) {
  let replyUser = document.getElementsByName(replyPostID)[0].innerHTML;
  let replyPost = document.getElementsByName(replyPostID)[1].innerHTML;
  let blockreply = document.getElementById("blockreply");
  let createReplyUser = document.getElementById("replyUser");
  let createReplySubject = document.getElementById("replySubject");
  blockreply.style.display = "block";
  createReplyUser.innerHTML = replyUser;
  createReplySubject.innerHTML = replyPost;
  let inputReplyIDField = document.getElementById("replyID");
  inputReplyIDField.value = replyPostID;
}

function doCancel() {
  document.getElementById("blockreply").style.display = "none";
  document.getElementById("replyID").value = "";
}

function showDropdownMenu(id) {
  $("#myDropdown-" + id).toggle("show");
}

function doDeleteForum(id, name,){
    const message = `Do you want to delete forum: ${name}\nType 'confirm'`;
    let confirm = window.prompt(message);
    if(confirm === 'confirm'){
       window.location.href="delete/forum?id=" + id; 
    }
}

function doDelete(postID, feature){
    const message = `Do you want to delete this ${feature}`;
    let confirm = window.confirm(message);
    if(confirm){
       window.location.href="../delete/" + feature  +"?id=" + postID; 
    }
}
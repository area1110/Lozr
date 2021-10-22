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

function removeSpace() {
    let input = document.querySelectorAll("input[type=text]");
    for (let eachInput of input) {
        eachInput.value = eachInput.value.trim();
    }
}

function display_error() {
    var errorLabel = document.getElementById("error");
    errorLabel.style.display = "none";
}

function checkSubmit(event, formId, inputId) {
    event.preventDefault();
    const insert = document.getElementById(inputId);
    const form = document.getElementById(formId);
    checkString = insert.value.trim();
    if (checkString !== "") {
        form.submit();
        reloadDelay();
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
    $("#myDropdown-" + id).toggle("fast");
}


function reloadDelay() {
    window.setTimeout(() => {
        window.location.reload();
    }, 500);
}

function doDelete(ID, reportFor) {
    const dummyframe = document.querySelector("#dummyframe");
    const message = `Do you want to delete this ${reportFor}`;
    let confirm = window.confirm(message);
    if (confirm) {
        dummyframe.src = "../delete/" + reportFor + "?id=" + ID;
        reloadDelay();
    }
}

function doReport(rootPath ,ID, reportFor) {
    const dummyframe = document.querySelector("#dummyframe");
    let reason = window.prompt("Please provide the reason for the report");
    if (!reason || reason === "") {
        return;
    } else {
        reason = reason.replaceAll(" ", "+");
        window.location.href = `${rootPath}/report/${reportFor}?id=${ID}&reason=${reason}`;
    }
}

//popup-form-edit
function openForm(forumID) {
    document.getElementById("formEdit").style.visibility = "visible";
    document.getElementById("elementeID").value = forumID;
}

function closeForm() {
    document.getElementById("formEdit").style.visibility = "hidden";
//    document.getElementById("elementeID").removeAttribute("value");
//    document.getElementById("cover-url").removeAttribute("value");
//    document.getElementById("output-cover-img").src = 'https://via.placeholder.com/200x130';
}
//
//


//autosubmit-changing-admin-in-user-page
function changePermission(userID) {
//    let isadmin = document.getElementById("admin-tickbox").checked;
//    let formData = new FormData();
//    formData.set('userID', userID);
//    formData.set('isAdmin', isadmin);
//    fetch('../update/user/permission', {method: "POST", body: formData});
    document.getElementById("changePermissionForm-" + userID).submit();
}


//navbar diy
/* Set the width of the sidebar to 250px (show it) */
function openNav() {
    document.getElementById("mySidepanel").style.width = "300px";
//  $("#mySidepanel").toggle("slow");
}

/* Set the width of the sidebar to 0 (hide it) */
function closeNav() {
//    $("#mySidepanel").toggle("slow");
    document.getElementById("mySidepanel").style.width = "0";
}


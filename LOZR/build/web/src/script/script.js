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


function reloadDelay(time) {
    if (!time) {
        time = 500;
    }
    window.setTimeout(() => {
        window.location.reload();
    }, time);
}

function doDelete(rootPath, ID, forWhat) {
    const dummyframe = document.querySelector("#dummyframe");
    const message = `Do you want to delete this ${forWhat}`;
    let confirm = window.confirm(message);
    if (confirm) {
        dummyframe.src = rootPath + "/delete/" + forWhat + "?id=" + ID;
        reloadDelay();
    }
}

function doDeleteUser(rootPath, ID, username) {
    const dummyframe = document.querySelector("#dummyframe");
    const message = `Do you want to CLOSE Your Account?\nPlease type '${username}' below to confirm`;
    let confirm = window.prompt(message);
    if (confirm === username) {
        dummyframe.src = rootPath + "/delete/user"  + "?id=" + ID;
        window.location.href = rootPath + "/logout";
    }
}

function doReport(rootPath, ID, reportFor) {
    const dummyframe = document.querySelector("#dummyframe");
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("target", "dummyframe");
    form.setAttribute("action", `${rootPath}/report/${reportFor}`);

    var id = document.createElement("input");
    id.setAttribute("type", "hidden");
    id.setAttribute("name", "id");
    id.value = ID;
    // Create an input element for date of birth
    var reason = document.createElement("input");
    reason.setAttribute("type", "hidden");
    reason.setAttribute("name", "reason");

    let string_reason = window.prompt("Please provide the reason for the report");
    if (!string_reason || string_reason === "") {
        return;
    } else {
        reason.value = string_reason;
        form.appendChild(id);
        form.appendChild(reason);
        dummyframe.appendChild(form);
        form.submit();
        window.alert('This thread has been reported to moderator');
    }
}

//popup-form-edit
function openForm(ID, select) {
    document.getElementById("formEdit").style.visibility = "visible";
    if (ID && select) {
        let form = document.getElementById("hidden-form");
        form[0].value = ID;
        // set in to summernote editor the content
        var markupStr = document.getElementById(select + '-' + ID).innerHTML;
        let smnote = $('#postContent');
        if (smnote.length)
            smnote.summernote('code', markupStr);
        else {
            form[1].value = markupStr;
        }
    }
}

function closeForm() {
    document.getElementById("formEdit").style.visibility = "hidden";
}



//autosubmit-changing-admin-in-user-page
function changePermission(userID) {
    document.getElementById("changePermissionForm-" + userID).submit();
}


//navbar diy
/* Set the width of the sidebar to 250px (show it) */
function openNav() {
    document.getElementById("mySidepanel").style.width = "300px";
}

/* Set the width of the sidebar to 0 (hide it) */
function closeNav() {
    document.getElementById("mySidepanel").style.width = "0";
}


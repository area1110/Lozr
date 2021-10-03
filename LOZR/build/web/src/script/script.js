function check_pass() {
    if (document.getElementById('password').value ===
            document.getElementById('repassword').value) {
        document.getElementById('repassErr').style.display = "none";
        document.getElementById('submit').disabled = false;
    } else {
        document.getElementById('repassErr').style.display = "block";
        document.getElementById('submit').disabled = true;
    }
}

function removeSpace() {
    const input = document.getElementsByTagName("input");
    for (let eachInput of input) {
        eachInput.value = eachInput.value.trim();
    }
}

function display_error() {
    const errorLabel = document.getElementById("error");

    errorLabel.style.display = "none";
}



document.getElementById("body").onload = getStatus;

var xhr = new XMLHttpRequest();
var getStatusReq = new XMLHttpRequest();

function updateStatus() {
    var newStatus = "status=" + encodeURIComponent(document.getElementById("status").value);
    //alert(newStatus);
    xhr.open("POST", "Controller?action=UpdateStatus", true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(newStatus);
    getStatus();
}

function getStatus() {
    getStatusReq.open("GET", "Controller?action=GetStatus", true);
    getStatusReq.onreadystatechange = getNewStatus;
    getStatusReq.send(null);
}

function getNewStatus() {
    if (getStatusReq.readyState == 4) {
        if (getStatusReq.status == 200) {
            var response = JSON.parse(getStatusReq.responseText);
            var status = response.status;
            var currentStatus = document.getElementById("current-status");
            currentStatus.innerText = status;
        }
    }
}
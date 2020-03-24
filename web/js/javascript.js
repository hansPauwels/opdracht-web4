window.onload = getFriends;

var xhr = new XMLHttpRequest();
var getStatusReq = new XMLHttpRequest();
var getFriendsReq = new XMLHttpRequest();

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

function addFriend() {
    var friendName = "fName=" + encodeURIComponent(document.getElementById("addfriend").value);
    alert(friendName);
    xhr.open("POST", "Controller?action=AddFriend", true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(friendName);
}

function getFriends() {
    getFriendsReq.open("GET", "Controller?action=GetFriendList", true);
    getFriendsReq.onreadystatechange = updateFriends;
    getFriendsReq.send(null);
}

function updateFriends() {
    if(getFriendsReq.readyState === 4) {
        if(getFriendsReq.status === 200) {
            var resp = JSON.parse(getFriendsReq.responseText);
            alert(resp);
            var friendsList = document.getElementById("friends");
            for (var i = 0; i < resp.length; i++) {
                var curObject = resp[i];
                for (var property in curObject) {

                }
            }
        }
    }

    //setTimeout(getFriends, 2000);
}
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hans
  Date: 03/03/2020
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<body id="body">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<main>
    <div id="status-div">
        <c:choose>
        <c:when test="${user == null}">
            <p>Please login first.</p>
        </c:when>
            <c:otherwise>
                <p id="current-status">${user.customStatus}</p>

    </div>
    <div id="friends-div">
        <table id="friends">
            <tr>
                <th>Name:</th>
                <th>Status:</th>
            </tr>
<%--            <c:forEach var="friend" items="${user.friends}">--%>
<%--                <tr>--%>
<%--                <td id="${user.firstName}"><p>${friend.firstName}</p></td>--%>
<%--                <td><p>${friend.customStatus}</p></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
        </table>

    </div>
<div id="status-container">
    <label for="status"><p>Change status: </p></label>
    <input type="text" name="status" id="status">
    <input type="button" value="Change" id="change-status" onclick="updateStatus()">
</div>
    <div id="addfriend-container">
        <label for="addfriend"><p>Add a friend: </p></label>
        <input type="text" name="addfriend" id="addfriend">
        <input type="button" value="Add friend" id="add-btn" onclick="addFriend()">
    </div>
    </c:otherwise>
    </c:choose>
</main>
<script src="js/javascript.js"></script>
</body>
</html>

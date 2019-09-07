<%--
  Created by IntelliJ IDEA.
  User: Borris
  Date: 10.06.2019
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/png" href="<c:url value="/res/icon.png"/>"/>
    <c:choose>
        <c:when test="${empty game.game}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
<c:url value="/add" var="addUrl"/>
<c:url value="/edit" var="editUrl"/>
<form class="style" action="${empty game.game ? addUrl : editUrl}" name="game" method="POST">
    <c:choose>
        <c:when test="${!empty game.game}">
            <p class="heading">Edit game</p>
            <input type="hidden" name="id" value="${game.id}">
        </c:when>
        <c:otherwise>
            <p class="heading">Add new game</p>
        </c:otherwise>
    </c:choose>

    <p><input type="text" name="game" placeholder="game" value="${game.game}" maxlength="50" required autofocus
              pattern="^[^\s]+(\s.*)?$">
    <p><input type="number" name="year" placeholder="year" value="${game.year}" maxlength="4" required
              oninput="if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
    <p><input type="text" name="genre" placeholder="genre" value="${game.genre}" maxlength="20" required>
    <p><input type="text" name="developer" placeholder="developer" value="${game.developer}" maxlength="50" required>
    <p><input type="text" name="processor" placeholder="processor" value="${game.processor}" maxlength="50" required>
    <p><input type="text" name="videocard" placeholder="videocard" value="${game.videocard}" maxlength="50" required>
    <p><input type="number" step="any" name="memory" placeholder="memory" value="${game.memory}" maxlength="10" required>
    <p><input type="number" step="any" name="freesize" placeholder="freesize" value="${game.freesize}" maxlength="10" required>
    <p><input type="number" step="any" name="price" placeholder="price" value="${game.price}" maxlength="10" required>
    <p><input type="text" name="launcher" placeholder="launcher" value="${game.launcher}" maxlength="50" required>

        <p class="checkbox">
        <label for="watched">installed
            <c:if test="${game.installed == true}">
                <input type="checkbox" name="installed" id="watched" value="${game.installed}" checked>
            </c:if>
            <c:if test="${game.installed != true}">
                <input type="checkbox" name="installed" id="watched">
            </c:if>
            <span class="checkbox-common checkbox-no">no</span>
            <span class="checkbox-common checkbox-yes">yes</span>
        </label>
    </p>
    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${empty game.game ? add : edit}">
    </p>
    <p class="heading">${message}</p>
</form>
</body>
</html>
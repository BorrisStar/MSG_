<%--
  Created by IntelliJ IDEA.
  User: Borris
  Date: 10.06.2019
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>GAMES</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/png" href="<c:url value="/res/icon.png"/>"/>

</head>
<body>
<table class="style">
    <caption class="heading">Games</caption>
    <c:if test="${gamesCount > 0}">
        <tr>
            <th class="left-side">№</th>
            <th style="width: 100%">game</th>
            <th>year</th>
            <th>genre</th>
            <th>developer</th>
            <th>processor</th>
            <th>videocard</th>
            <th>memory,GB</th>
            <th>freesize,GB</th>
            <th>price,RUB</th>
            <th>launcher</th>
            <th>installed</th>
            <th colspan="2" class="right-side">action</th>
        </tr>
        <c:forEach var="item" items="${gamesList}" varStatus="i">
            <tr>
                <td class="left-side">${i.index + 1 + (page - 1) * 10}</td>
                <td class="game">${item.game}</td>
                <td>${item.year}</td>
                <td>${item.genre}</td>
                <td>${item.developer}</td>
                <td>${item.processor}</td>
                <td>${item.videocard}</td>
                <td>${item.memory}</td>
                <td>${item.freesize}</td>
                <td>${item.price}</td>
                <td>${item.launcher}</td>
                <td>
                    <c:if test="${item.installed == true}">
                        <span class="icon icon-installed"></span>
                    </c:if>
                </td>
                <td>

                    <a href="/edit/${item.id}">
                        <span class="icon icon-edit"></span>
                    </a>
                </td>
                <td class="right-side">
                    <a href="/delete/${item.id}">
                        <span class="icon icon-delete"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${gamesCount == 0}">
        <tr>
            <td colspan="7" style="font-size: 150%" class="left-side right-side">
                the list is empty but you can add a new game
            </td>
        </tr>
    </c:if>
    <tr>
        <td colspan="7" class="left-side link right-side">
            <a style="margin-right: 30px; font-size: 100%" href="<c:url value="/add"/>">
                <span class="icon icon-add"></span>Add new game
            </a>
            <a style="margin-right: 30px; font-size: 100%" href="<c:url value="/sort"/>">
                <span class="icon icon-find"></span>New games
            </a>
         <!--   <button style="margin-right: 70px; font-size: 100%" type="button" value="Sort">
                <span class="icon icon-find"></span>New games
            </button>-->
            <c:if test="${pagesCount > 1}">
                <c:set value="disabled" var="disabled"/>
                <c:set value="" var="active"/>
                <c:url value="/" var="url">
                    <c:param name="page" value="1"/>
                </c:url>
                <a class="${page == 1 ? disabled : active}" href="${url}">
                    &nbsp<span class="icon icon-first"></span>&nbsp
                </a>
                <c:url value="/" var="url">
                    <c:param name="page" value="${page - 1}"/>
                </c:url>
                <a class="${page == 1 ? disabled : active}" href="${url}">
                    &nbsp<span class="icon icon-prev"></span>&nbsp
                </a>

                <c:if test="${pagesCount <= 5}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pagesCount}"/>
                </c:if>
                <c:if test="${pagesCount > 5}">
                    <c:choose>
                        <c:when test="${page < 3}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="5"/>
                        </c:when>
                        <c:when test="${page > pagesCount - 2}">
                            <c:set var="begin" value="${pagesCount - 4}"/>
                            <c:set var="end" value="${pagesCount}"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="begin" value="${page - 2}"/>
                            <c:set var="end" value="${page + 2}"/>
                        </c:otherwise>
                    </c:choose>
                </c:if>

                <c:forEach begin="${begin}" end="${end}" step="1" varStatus="i">
                    <c:url value="/" var="url">
                        <c:param name="page" value="${i.index}"/>
                    </c:url>
                    <c:set value="current-page" var="current"/>
                    <c:set value="" var="perspective"/>
                    <a class="${page == i.index ? current : perspective}" href="${url}">${i.index}</a>
                </c:forEach>

                <c:url value="/" var="url">
                    <c:param name="page" value="${page + 1}"/>
                </c:url>
                <a class="${page == pagesCount ? disabled : active}" href="${url}">
                    &nbsp<span class="icon icon-next"></span>&nbsp
                </a>
                <c:url value="/" var="url">
                    <c:param name="page" value="${pagesCount}"/>
                </c:url>
                <a class="${page == pagesCount ? disabled : active}" href="${url}">
                    &nbsp<span class="icon icon-last"></span>&nbsp
                </a>
            </c:if>
            <span style="margin-right: 30px; font-size: 120%">Total Games: ${gamesCount}</span>
        </td>
    </tr>
</table>
</body>
</html>
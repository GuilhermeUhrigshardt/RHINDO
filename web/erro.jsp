<%-- 
    Document   : erro
    Created on : May 22, 2017, 5:06:54 PM
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <center>
            <h1>RH-INDO</h1>
            <c:choose>
                <c:when test="${!empty param.msg}">
                    <h3>${param.msg}</h3>
                </c:when>
                <c:otherwise>
                    <h3>${msg}</h3>
                </c:otherwise>
            </c:choose>
        </center>
    </body>
</html>
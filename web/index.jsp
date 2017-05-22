<%-- 
    Document   : index
    Created on : May 21, 2017, 5:25:13 PM
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RH-INDO</title>
    </head>
    <body>
        <center>
            <h4>${msg}</h4>
            <h2>RH-INDO</h2>
            <form action="http://localhost:21836/RHINDO/ProcessaLogin" method="post">
                Email:<input type="text" name="email" id="email"><br/>
                Senha:<input type="password" name="senha" id="senha"><br/>
                <input type="submit" value="Logar">
            </form>
        </center>
    </body>
</html>

<%-- 
    Document   : relatorios_funcionario
    Created on : May 21, 2017, 7:15:22 PM
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${sessionScope.funcionario == null || (sessionScope.funcionario.departamento.nomeDepartamento == 'RH' && sessionScope.funcionario.cargo.nomeCargo == 'Gerente')}"> 
    <c:redirect url="/erro.jsp">
        <c:param name="msg" value="Acesso negado!"/>
    </c:redirect>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatórios</title>
    </head>
    <body>
        <div style="text-align:left;">
            Bem vindo, Guilherme Uhrigshardt<span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
        <h1>Relatórios</h1>
    </body>
</html>

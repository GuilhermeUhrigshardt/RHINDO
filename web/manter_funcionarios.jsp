<%-- 
    Document   : manter_funcionarios
    Created on : May 21, 2017, 7:14:58 PM
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${sessionScope.funcionario.departamento.nomeDepartamento == 'Gerencia' || sessionScope.funcionario.cargo.nomeCargo == 'Presidente'}"> <!--Trcar para RH e Gerente-->
    <c:redirect url="/erro.jsp">
        <c:param name="msg" value="Acesso negado!"/>
    </c:redirect>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Funcionários</title>
    </head>
    <body>
        <div style="text-align:left;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
        <center>
            <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/folhas.jsp">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
            <br/><br/><br/>
            <form action="http://localhost:21836/RHINDO/BuscarFuncionario" method="POST">
                <input type="text" name="buscaFuncionario" placeholder="Buscar por nome">
                <input type="submit" value="Buscar">
            </form>
        </center>
    </body>
</html>

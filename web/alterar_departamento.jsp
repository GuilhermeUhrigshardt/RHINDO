<%-- 
    Document   : alterar_departamento
    Created on : May 23, 2017, 7:15:55 PM
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${sessionScope.funcionario.departamento.nomeDepartamento != 'Gerencia' || sessionScope.funcionario.cargo.nomeCargo != 'Presidente'}"> <!--Trcar para RH e Gerente-->
    <c:redirect url="/erro.jsp">
        <c:param name="msg" value="Acesso negado!"/>
    </c:redirect>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Departamento</title>
    </head>
    <body>
        <div style="text-align:left;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
        <center>
            <h2>RH-INDO</h2>
            <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/folhas.jsp">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
            <br/><br/><br/>
            <h3>Alterar Departamento</h3>
            <br/>
            <form action="AlterarDepartamento" method="POST">
                <input type="hidden" name="Id" value="<c:out value="${departamento.idDepartamento}"/>">
                Nome: <input type="text" name="Nome" value="<c:out value="${departamento.nomeDepartamento}"/>">
                <br/>
                Localização: <input type="text" name="Localizacao" value="<c:out value="${departamento.localizacao}"/>">
                <br/>
                <input type="submit" value="Alterar">
            </form>
        </center>
    </body>
</html>

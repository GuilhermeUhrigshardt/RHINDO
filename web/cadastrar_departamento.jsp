<%-- 
    Document   : cadastrar_departamento
    Created on : May 24, 2017, 7:50:43 PM
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${sessionScope.funcionario.departamento.nomeDepartamento != 'RH' || sessionScope.funcionario.cargo.nomeCargo != 'Gerente'}"> <!--Trcar para RH e Gerente-->
    <c:redirect url="/erro.jsp">
        <c:param name="msg" value="Acesso negado!"/>
    </c:redirect>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Departamento</title>
    </head>
    <body>
        <div style="text-align:left;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
        <center>
            <h2>RH-INDO</h2>
            <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/folhas.jsp">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
            <br/><br/><br/>
            <h3>Cadastrar Departamento</h3>
            <br/>
            <form action="CadastrarDepartamento" method="POST">
                Nome: <input type="text" name="Nome" placeholder="Nome">
                <br/>
                Localização: <input type="text" name="Localizacao" placeholder="Localização">
                <br/>
                <input type="reset" value="Limpar">
                <input type="submit" value="Cadastrar">
            </form>
        </center>    
    </body>
</html>

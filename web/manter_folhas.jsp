<%-- 
<%-- 
    Document   : folhas
    Created on : May 22, 2017, 5:27:35 PM
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
        <title>Folhas</title>
    </head>
    <body>
        <div style="text-align:right;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
    <center>
        <h2>RH-INDO</h2>
        <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/Folha">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
        <h1>Fechamento de Folha</h1>
        <form action="Folha" method="POST">
            Departamentos:              
                <select name="listaDepartamentos">
                    <c:forEach items="${lista}" var="dep">
                        <option value="${dep.idDepartamento}">${dep.nomeDepartamento}</option>
                    </c:forEach>
                </select><br>
            Mês:
                <select name="mes">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
                <br/>
            <a href="FecharFolha"><input type="button" value="Fechar Folha"/></a>
        </form>
    </center>
</body>
</html>

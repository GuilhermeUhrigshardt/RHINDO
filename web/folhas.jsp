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
        <div style="text-align:left;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
    <center>
        <h2>RH-INDO</h2>
        <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/folhas.jsp">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
        <h2>Fechamento de Folha</h2>
        <tr>
            <th>Departamentos: </th>
            <th>                
                <select name="listaDepartamentos">
                    <c:forEach var="listaDepartamentos" items="${lista}">
                        <option value="${item.nomeDepartamento}">${item.nomeDepartamento}</option>
                    </c:forEach>
                </select><br>
            </th>
        </tr>
        <tr>
            <td>
            <th>Mês: </th>
            </td>
            <td>
                <select name="mes">
                    <option value="janeiro">1</option>
                    <option value="fevereiro">2</option>
                </select><br>
            </td>
        </tr>

        <a href="FecharFolha"><input type="button" value="Fechar Folha"/></a>
    </center>
</body>
</html>

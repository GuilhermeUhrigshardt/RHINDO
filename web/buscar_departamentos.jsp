<%-- 
    Document   : buscar_departamentos
    Created on : May 22, 2017, 9:22:59 PM
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
        <title>Buscar Departamentos</title>
    </head>
    <body>
        <div style="text-align:left;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
        <center>
            <h2>RH-INDO</h2>
            <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/folhas.jsp">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
            <br/><br/><br/>
            <h3>Busca Departamentos</h3>
            <br/>
            <c:choose>
                <c:when test="${!empty lista}">
                    <table border="1" cellspacing="1">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Localização</th>
                            <th>Alterar</th>
                            <th>Deletar</th>                            
                        </tr>
                        <c:forEach items="${lista}" var="item">
                            <tr>
                                <td>${item.idDepartamento}</td>
                                <td>${item.nomeDepartamento}</td>
                                <td>${item.localizacao}</td>
                                <td><a href="AlterarDepartamento?dep=<c:out value="${item.idDepartamento}"/>"><input type="button" name="Alterar" value="Alterar" /></a></td>
                                <td><a href="RemoverDepartamento?dep=<c:out value="${item.idDepartamento}"/>"><input type="button" name="Remover" value="Remover" /></a></td>                                
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <h4>Não foram encontrados departamentos com este nome!</h4>
                </c:otherwise>
            </c:choose>
        </center>
    </body>
</html>

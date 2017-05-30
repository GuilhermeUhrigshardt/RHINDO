<%-- 
    Document   : alerar_funcionario
    Created on : May 30, 2017, 3:47:30 PM
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
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/jquery.mask.js" type="text/javascript"></script>
        <script src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Funcionário</title>
    </head>
    <body>
        <div style="text-align:left;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
        <center>
            <h2>RH-INDO</h2>
            <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/folhas.jsp">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
            <br/><br/><br/>
            <h3>Alterar Funcionário</h3>
            <br/>
            <form action="AlterarFuncionario" method="POST">
                <input type="hidden" name="Id" value="<c:out value="${funcionario.idFuncionario}"/>">
                Nome: <input type="text" name="Nome" value="${funcionario.nomeFuncionario}">
                <br/>
                CPF: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="Cpf" id="cpf" value="${funcionario.cpfFormatado}">
                <br/>
                RG: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="Rg" id="rg" value="${funcionario.rgFormatado}">
                <br/>
                Celular: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="Celular" id="cel" value="${funcionario.celularFormatado}">
                <br/>
                Email: <input type="email" name="Email" value="${funcionario.email}">
                <br/>
                Rua: <input type="text" name="Rua" value="${funcionario.endereco.rua}">
                <br/>
                Número: <input type="text" name="Numero" onkeypress='return event.charCode >= 48 && event.charCode <= 57' value="${funcionario.endereco.numero}">
                <br/>
                Bairro: <input type="text" name="Bairro" value="${funcionario.endereco.bairro}">
                <br/>
                CEP: <input type="text" name="Cep" onkeypress='return event.charCode >= 48 && event.charCode <= 57' id="cep" value="${funcionario.endereco.cepFormatado}">
                <br/>
                Cidade: <input type="text" name="Cidade" value="${funcionario.endereco.cidade}">
                <br/>
                Estado: 
                <select name="Estado">
                    <c:forEach items="${listaEndereco}" var="uf">
                        <option value="${uf.idUf}">${uf.uf}</option>
                    </c:forEach>
                </select>
                <br/>
                Departamento: 
                <select name="Departamento">
                    <c:forEach items="${listaDepartamento}" var="departamento">
                        <option value="${departamento.idDepartamento}">${departamento.nomeDepartamento}</option>
                    </c:forEach>
                </select>
                <br/>
                Cargo: 
                <select name="Cargo">
                    <c:forEach items="${listaCargo}" var="cargo">
                        <option value="${cargo.idCargo}">${cargo.nomeCargo}</option>
                    </c:forEach>
                </select>
                <br/>
                <input type="submit" value="Alterar">
            </form>
        </center>
        <script type="text/javascript">
            $(document).ready(function(){
              $('#cep').mask('00000-000');
              $('#cel').mask('(00)00000-0000');
              $('#cpf').mask('000.000.000-00', {reverse: true});
              $('#rg').mask('00.000.000-0', {reverse: true});
            });
        </script>
    </body>
</html>

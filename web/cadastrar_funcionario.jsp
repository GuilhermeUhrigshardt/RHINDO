<%-- 
    Document   : cadastrar_funcionario
    Created on : May 26, 2017, 7:34:57 PM
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
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/jquery.mask.js" type="text/javascript"></script>
        <script src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionário</title>
    </head>
    <body>
        <div style="text-align:left;">
            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"><a href="/RHINDO/ProcessaLogout">Logout</a></span>
        </div>
        <center>
            <h2>RH-INDO</h2>
            <a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a> | <a href="/RHINDO/manter_departamentos.jsp">Departamentos</a> | <a href="/RHINDO/manter_cargos.jsp">Cargos</a> | <a href="/RHINDO/folhas.jsp">Folhas</a> | <a href="/RHINDO/relatorios.jsp">Relatórios</a>
            <br/><br/><br/>
            <h3>Cadastrar Cargo</h3>
            <br/>
            <form action="CadastrarCargo" method="POST">
                Nome: <input type="text" name="Nome" placeholder="Nome">
                <br/>
                CPF: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="Cpf" placeholder="CPF">
                <br/>
                RG: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="Rg" placeholder="RG">
                <br/>
                Celular: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="CargaMinima" placeholder="(99)99999-9999">
                <br/>
                Email: <input type="email" name="Email" placeholder="email@example.com">
                <br/>
                Rua: <input type="text" name="Rua" placeholder="Av. das Torres">
                <br/>
                Número: <input type="text" name="Numero" onkeypress='return event.charCode >= 48 && event.charCode <= 57' placeholder="999">
                <br/>
                Bairro: <input type="text" name="Bairro" placeholder="Jardim das Americas">
                <br/>
                CEP: <input type="text" name="Cep" onkeypress='return event.charCode >= 48 && event.charCode <= 57' placeholder="99999-999">
                <br/>
                Cidade: <input type="text" name="Cidade" placeholder="Curitiba">
                <br/>
                Estado: 
                <select>
                    <c:forEach items="${listaEndereco}" var="uf">
                        <option value="${uf.uf}">${uf.uf}</option>
                    </c:forEach>
                </select>
                <br/>
                Departamento: 
                <select>
                    <c:forEach items="${listaDepartamento}" var="departamento">
                        <option value="${departamento.nomeDepartamento}">${departamento.nomeDepartamento}</option>
                    </c:forEach>
                </select>
                <br/>
                Cargo: 
                <select>
                    <c:forEach items="${listaCargo}" var="cargo">
                        <option value="${cargo.nomeCargo}">${cargo.nomeCargo}</option>
                    </c:forEach>
                </select>
                <br/>
                Senha: <input type="text" name="DescontoImpostos" onchange="handleChange(this);" onkeypress='return event.charCode >= 48 && event.charCode <= 57' placeholder="Desconto Impostos(%)">
                <br/>
                Confirmar Senha: <input type="text" name="DescontoImpostos" onchange="handleChange(this);" onkeypress='return event.charCode >= 48 && event.charCode <= 57' placeholder="Desconto Impostos(%)">
                <br/>
                <input type="reset" value="Limpar">
                <input type="submit" value="Cadastrar">
            </form>
        </center>
        <script type="text/javascript">            
        </script>
    </body>
</html>

<%-- 
    Document   : cadastrar_cargo
    Created on : May 24, 2017, 7:50:55 PM
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Cadastrar Cargo</title>
    </head>
    <body>
        <center>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="/RHINDO/manter_funcionarios.jsp"><img src="/RHINDO/css/logo0.png"style="width: 76%; margin: -1vh"></a>
                  </div>
                  <ul class="nav navbar-nav">
                    <li><a href="/RHINDO/manter_funcionarios.jsp">Funcionários</a></li>
                    <li><a href="/RHINDO/manter_departamentos.jsp">Departamentos</a></li>
                    <li><a href="/RHINDO/manter_cargos.jsp">Cargos</a></li>
                    <li><a href="/RHINDO/manter_folhas.jsp">Folhas</a></li>
                    <li><a href="/RHINDO/RelatoriosGerente">Relatórios</a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                    <li>
                        <div style="margin-top: 2vh; color: #ccc; ">
                            Bem vindo, <c:out value="${sessionScope.funcionario.nomeFuncionario}"/><span style="float:right;"></span>
                        </div>
                    </li>
                    <li><a href="/RHINDO/ProcessaLogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                  </ul>
                </div>
            </nav>
            <br/><br/><br/>
            <h1>Cadastrar Cargo</h1>
            <br/>
            <div class="container " style="width: 50%">
                <form action="CadastrarCargo" class="form-group jumbotron" method="POST" role="form" style="text-align: left">
                    <label>Nome:</label> <input type="text" class="form-control" name="Nome" placeholder="Nome">
                    <br/>
                    <label>Salário:</label> <input type="text" class="form-control" name="Salario" id="valor" placeholder="R$0,00">
                    <br/>
                    <label>Requisitos:</label> <input type="text" class="form-control" name="Requisitos" placeholder="Requisitos">
                    <br/>
                    <label>Carga Mínima:</label> <input type="text" class="form-control" name="CargaMinima" onkeypress='return event.charCode >= 48 && event.charCode <= 57' placeholder="Carga Mínima(horas)">
                    <br/>
                    <label>Desconto Impostos:</label> <input type="text" class="form-control" name="DescontoImpostos" onkeypress='return event.charCode >= 48 && event.charCode <= 57' onchange="handleChange(this);" placeholder="Desconto Impostos(%)">
                    <br/>
                    <input type="reset" class="btn btn-primary" value="Limpar">
                    <input type="submit" class="btn btn-primary" value="Cadastrar">
                </form>
            </div>
        </center>
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/jquery.mask.js" type="text/javascript"></script>
        <script src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("#valor").val(R$0,00);
            });
            $(document).focusin(function(){
                $("#valor").maskMoney({symbol:'R$', showSymbol:true, thousands:'.', decimal:',', symbolStay: true});
            });            
            function handleChange(input) {
                if (input.value < 0) input.value = 0;
                if (input.value > 100) input.value = 100;
            }
        </script>
    </body>
</html>

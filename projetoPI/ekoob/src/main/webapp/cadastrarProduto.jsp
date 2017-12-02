<%-- 
    Document   : cadastroProduto
    Created on : 02/12/2017, 13:01:39
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <nav>
        <div class="full-width navbar">
            <h2 class="brand">e-koob</h2>
            <ul>
                <li><a class="active" href="home.jsp">Home</a></li>
                <li><a href="cadastrarCliente.jsp">Cliente</a></li>
                <li><a href="#">Produto</a></li>
                <li><a href="#">Fornecedor</a></li>
                <li><a href="#">Usuário</a></li>
                <li><a href="#">Venda</a></li>
                <li><a href="#">Relatório</a></li>
            </ul>
            <div style="clear: both"></div>
        </div>
    </nav>
    <body>
        <section>
            <div id="box" class="container-fluid">
                <div class="container">
                    <div class="formBox">

                        <form id="registerform" name="registerform">
                            <div class="row">
                                <div class="col-sm-12">
                                    <h1>Cadastrar Produto</h1>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Nome</div>
                                            <input type="text" maxlength="50" size="50" name="nome" class="input required" id="fnome">

                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Autor</div>
                                            <input id="cpf" type="number" maxlength="11" size="11" name="" class="input required">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Editora</div>
                                            <input type="text" name="email" class="input required email">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Telefone</div>
                                            <input type="number" maxlength="12" size="12" name="numero" class="input required ">
                                        </div>

                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">CEP</div>
                                        <input id="cep" type="number" maxlength="8" size="8" name="numero" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Rua</div>
                                        <input id="rua" type="text" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Cidade</div>
                                        <input id="cidade" type="text" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">UF</div>
                                        <input id="uf" type="text" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Número</div>
                                        <input  type="number" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-12">
                                    <input type="submit" name="" value="Salvar" class="button">
                                </div>
                            </div>
                    </div>
                    </form>

                </div>
            </div>

        </div>
    </section>
</body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ProdutoDAO;
import com.aztec.koob.model.Produto;
import com.aztec.koob.validadores.ValidadorData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilherme.gcosta6
 */
@WebServlet(name = "CadastroProduto", urlPatterns = {"/cadastro-produto"})
public class CadastroProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino;

        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("produto") != null) {

            request.setAttribute("mensagem", "Produto cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/CadastroProduto.jsp");
            dispatcher.forward(request, response);

            destino = "CadastrarProduto.jsp";

        } else {

            destino = "CadastroProduto.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        String nome = request.getParameter("nome");
        String autor = request.getParameter("autor");
        String editora = request.getParameter("editora");
        String ano = request.getParameter("ano");
        Integer quantidade = Integer.parseInt(request.getParameter("qtd"));
        double preco = Double.parseDouble(request.getParameter("preco"));

        Produto produto = new Produto(nome, autor, editora, ano, quantidade, preco);

        produto.setNome(nome);
        produto.setAutor(autor);
        produto.setEditora(editora);
        produto.setAno(ano);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);

        try {
            ProdutoDAO.inserirProduto(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/cadastro-produto");

    }
}

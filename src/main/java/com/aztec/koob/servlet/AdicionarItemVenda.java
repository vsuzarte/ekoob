/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.mock.MockVenda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aztec.koob.model.ItemVenda;
import com.aztec.koob.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabriel.sleal1
 */
@WebServlet(name = "AdicionarItemVenda", urlPatterns = {"/adicionar-item-venda"})
public class AdicionarItemVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Produto produto = (Produto) sessao.getAttribute("produto");
        int quantidade = 0;
        try {
            quantidade = Integer.parseInt(request.getParameter("quantidade"));
        } catch (Exception e) {
            quantidade = 1;
        }

        ItemVenda item = new ItemVenda();
        item.setIdProduto(produto.getId());
        item.setNome(produto.getNome());
        item.setPreco(produto.getPreco());
        item.setQtde(quantidade);

        double valor = quantidade * item.getPreco();

        item.setValor(valor);

        if (MockVenda.listaDeItemVenda.size() == 0) {
            MockVenda.listaDeItemVenda.add(item);
        } else {

            for (int i = 0; i < MockVenda.listaDeItemVenda.size(); i++) {
                if (MockVenda.listaDeItemVenda.get(i).getIdProduto() == item.getIdProduto()) {
                    MockVenda.listaDeItemVenda.get(i).setQtde(MockVenda.listaDeItemVenda.get(i).getQtde() + quantidade);
                    MockVenda.listaDeItemVenda.get(i).setValor(MockVenda.listaDeItemVenda.get(i).getValor() + valor);
                    break;
                }
                if (i == MockVenda.listaDeItemVenda.size() - 1) {
                    MockVenda.listaDeItemVenda.add(item);
                }
            }
        }

        List<ItemVenda> lista = MockVenda.listaDeItemVenda;

        request.setAttribute("lista", lista);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/venda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}

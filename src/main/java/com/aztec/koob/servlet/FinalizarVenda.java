/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ItemDAO;
import com.aztec.koob.dao.VendaDAO;
import com.aztec.koob.model.Cliente;
import com.aztec.koob.model.Usuario;
import com.aztec.koob.model.Venda;
import com.aztec.koob.model.ItemVenda;

import com.aztec.koob.mock.MockVenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabriel.sleal1
 */
@WebServlet(name = "FinalizarVenda", urlPatterns = {"/finalizar-venda"})
public class FinalizarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venda venda = new Venda();
        //POQUE TÁ PULANDO ESSA PORRA ????????????????
        int ultimaVenda = 0;

        HttpSession sessao = request.getSession();

        int idCliente = (int) sessao.getAttribute("idCliente");
        int idProduto = (int) sessao.getAttribute("idProduto");
        venda.setIdCliente(idCliente);
        double valor = MockVenda.calcularValor();
        venda.setValor(valor);

        MockVenda.listaDeVenda.add(venda);

        try {
            VendaDAO.inserirVenda(idCliente, valor);
            MockVenda.listaDeVenda = MockVenda.serviço();
            ultimaVenda = MockVenda.listaDeVenda.get(MockVenda.listaDeVenda.size() - 1).getId();

        } catch (Exception E) {
            E.printStackTrace();
        }

        for (int i = 0; i < MockVenda.listaDeItemVenda.size(); i++) {
            try {

                ItemDAO.adicionarItemVenda(ultimaVenda, MockVenda.listaDeItemVenda.get(i).getIdProduto(), MockVenda.listaDeItemVenda.get(i).getQtde());
            } catch (Exception e) {
                e.printStackTrace();

            }

        }

        response.sendRedirect(request.getContextPath() + "/venda.jsp");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ItemVendaDAO;
import com.aztec.koob.dao.VendaDAO;
import com.aztec.koob.model.Cliente;
import com.aztec.koob.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.aztec.koob.mock.MockVenda;
import com.aztec.koob.model.Venda;

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

        HttpSession sessao = request.getSession();

        int idCliente = (int) sessao.getAttribute("idCliente");
        venda.setIdCliente(idCliente);
        double valor = MockVenda.calcularValor();
        venda.setValor(valor);

        try {
            VendaDAO.inserirVenda(idCliente, valor);
        } catch (Exception E) {

       

        for (int i = 0; i < MockVenda.listaDeItemVenda.size(); i++) {
            try {
                ItemVendaDAO.adicionarItemVenda(venda.getId(), MockVenda.listaDeItemVenda.get(i).getIdProduto());
            } catch (Exception e) {

            }

        }

  
        response.sendRedirect(request.getContextPath() + "/venda.jsp");

    }

}

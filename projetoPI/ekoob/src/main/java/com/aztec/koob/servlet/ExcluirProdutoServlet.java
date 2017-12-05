/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ClienteDAO;
import com.aztec.koob.dao.ProdutoDAO;
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

/**
 *
 * @author Vitor
 */
@WebServlet(name = "ExcluirProdutoServlet", urlPatterns = {"/ExcluirProdutoServlet"})
public class ExcluirProdutoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("idProduto"));
        
        try {
            ProdutoDAO.excluirProduto(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        response.sendRedirect(request.getContextPath() + "/consultarProduto.jsp");
        //RequestDispatcher rd = request.getRequestDispatcher("/consultarCliente.jsp");
        //rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}

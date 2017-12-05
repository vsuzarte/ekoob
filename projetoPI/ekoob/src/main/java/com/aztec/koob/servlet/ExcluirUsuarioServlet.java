/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ClienteDAO;
import com.aztec.koob.dao.UsuarioDAO;
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
@WebServlet(name = "ExcluirUsuarioServlet", urlPatterns = {"/ExcluirUsuarioServlet"})
public class ExcluirUsuarioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        
        try {
            UsuarioDAO.excluirUsuario(id);
        } catch (Exception ex) {
            Logger.getLogger(ExcluirClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.sendRedirect(request.getContextPath() + "/consultarUsuario.jsp");
        //RequestDispatcher rd = request.getRequestDispatcher("/consultarCliente.jsp");
        //rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}

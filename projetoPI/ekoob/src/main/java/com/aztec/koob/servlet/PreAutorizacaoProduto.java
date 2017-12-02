/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "PreAutorizacaoProduto", urlPatterns = {"/autorizacao-produto"})
public class PreAutorizacaoProduto extends HttpServlet {

  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpServletRequest httpRequest = (HttpServletRequest) request; // cast
      HttpServletResponse httpResponse = (HttpServletResponse) response;

      HttpSession sessao = httpRequest.getSession();
    if (sessao != null && sessao.getAttribute("usuario") != null) {
      // Usuario esta logado
      
      Usuario usuario = (Usuario) sessao.getAttribute("usuario");
      String funcao = usuario.getFuncao();
      
      
      if (funcao.equals("estoquista")||funcao.equals("gerente")) {
	 RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/cadastrarProduto.jsp");
                dispatcher.forward(request, response);
      } else {
	 request.setAttribute("mensagemErro", "Acesso não autorizado");
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/home.jsp");
                dispatcher.forward(request, response);
      }
    } else {
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
      return;
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

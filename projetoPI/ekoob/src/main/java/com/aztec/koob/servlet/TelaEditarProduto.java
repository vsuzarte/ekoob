/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ClienteDAO;
import com.aztec.koob.dao.ProdutoDAO;
import com.aztec.koob.model.Cliente;
import com.aztec.koob.model.Produto;
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
 * @author Vitor
 */
@WebServlet(name = "TelaEditarProduto", urlPatterns = {"/tela-editar-produto"})
public class TelaEditarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Produto cliente = null;
        
        int id = Integer.parseInt(request.getParameter("idProduto"));

        try {

            cliente = ProdutoDAO.obterProduto(id);
            
            
        request.setAttribute("idProduto", cliente.getId());
        request.setAttribute("nome", cliente.getNome());
        request.setAttribute("estoque", cliente.getQuantidade());
        request.setAttribute("autor", cliente.getAutor());
        request.setAttribute("editora", cliente.getEditora());
        request.setAttribute("ano", cliente.getAno());
        request.setAttribute("preco", cliente.getPreco());
        
       

        this.getServletContext().getRequestDispatcher("/editarProduto.jsp").forward(request, response);
        
    
            

        } catch (Exception e) {

        }

      
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
      
    }

}

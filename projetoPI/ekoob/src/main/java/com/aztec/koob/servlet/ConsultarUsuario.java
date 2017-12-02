/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.UsuarioDAO;
import com.aztec.koob.model.Usuario;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "Consultaru", urlPatterns = {"/consultarUsuario"})
public class ConsultarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuario;
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));

        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        try {

            String nome = request.getParameter("nome");

            listaUsuario = UsuarioDAO.procurarUsuario(nome);
            request.setAttribute("listaUsuario", listaUsuario);

            if (nome == null || nome.equals("")) {
                listaUsuario = UsuarioDAO.listarUsuario();
                request.setAttribute("listaUsuario", nome);
            }

            sessao.setAttribute("listaUsuario", listaUsuario);
            response.sendRedirect(request.getContextPath() + "/ConsultarUsuario.jsp");

        } catch (Exception e) {
        }

    }

}

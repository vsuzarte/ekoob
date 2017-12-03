/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.autorizadores;

import com.aztec.koob.model.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebFilter(filterName = "AutorizacaoExcluirCliente", 
        servletNames = {"ExcluirClienteServlet"},
        urlPatterns = {"/consultarCliente.jsp*"})
public class AutorizacaoExcluirCliente implements Filter {
    
  
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request; // cast
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();
        if (sessao != null && sessao.getAttribute("usuario") != null) {
            // Usuario esta logado

            Usuario usuario = (Usuario) sessao.getAttribute("usuario");
            String funcao = usuario.getFuncao();

            if (funcao.equals("vendedor") || funcao.equals("gerente")) {
                chain.doFilter(request, response); // Comando que deixa requisição passar para proximo elemento.
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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       int i = 0;
    }

    @Override
    public void destroy() {
        int i = 0;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.aztec.koob.model.Usuario;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Gabriel
 */
@WebFilter(filterName = "AutorizacaoTI",
        servletNames = {"AlterarClienteServlet", "AlterarClienteServlet02",
            "CadastroCliente","CadastroProduto","ExcluirProdutoServlet","CadastroUsuario", "ExcluirClienteServlet"},
        urlPatterns = {"/protegido/*"})
public class AutorizacaoTI implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request; // cast
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();
        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        if (sessao != null && sessao.getAttribute("usuario") != null) {

            Usuario usuario = (Usuario) sessao.getAttribute("usuario");
            String funcao = usuario.getFuncao();

            if (funcao.equals("gerente") || funcao.equals("ti")) {
                chain.doFilter(request, response); // Comando que deixa requisição passar para proximo elemento.
            } else {
                request.setAttribute("mensagemErro", "Acesso não autorizado");
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/HomePage.jsp");
                dispatcher.forward(request, response);
            }
        }
        if (sessao == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
            return;
        }
    }

    @Override
    public void destroy() {

    }

}


package com.aztec.koob.autorizadores;

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
@WebFilter(filterName = "AutorizacaoProduto",
	servletNames = {"CadastroProduto"}, 
        
	urlPatterns = {"/cadastrarProduto.jsp*"})
public class AutorizacaoCadastrarProduto implements Filter {

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
    if (sessao != null && sessao.getAttribute("usuario") != null) {
      // Usuario esta logado
      
      Usuario usuario = (Usuario) sessao.getAttribute("usuario");
      String funcao = usuario.getFuncao();
      
      
      if (funcao.equals("estoquista")||funcao.equals("gerente")) {
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
  public void destroy() {

  }

}

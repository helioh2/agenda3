package br.ufpr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpr.logica.Logica;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nomeClasse = request.getParameter("logica");
		try {
			Class classe = Class.forName("br.ufpr.logica."+nomeClasse);
			Logica logica = (Logica) classe.newInstance();
			String visao = logica.executa(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher(visao);
			rd.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(
	                  "A lógica de negócios causou uma exceção", e);
		}
		
	}

}

package br.ufpr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdicionaContatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimentoTexto = request.getParameter("dataNascimento");
		
	
		Calendar dataNascimento = Calendar.getInstance();
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			dataNascimento.setTime(format.parse(dataNascimentoTexto));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		ContatoDao dao  = new ContatoDao(conexao);
		dao.adiciona(new Contato(nome, email, endereco, dataNascimento));
		
		
		//Redireciona
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

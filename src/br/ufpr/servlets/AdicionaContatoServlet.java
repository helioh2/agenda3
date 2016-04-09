package br.ufpr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		PrintWriter out = response.getWriter();
		out.println("Nome: "+nome);
		out.println("Email: "+email);
		out.println("Endereco: "+endereco);
		out.println("Data Nascimento: "+dataNascimentoTexto);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/aaaa");
		//Calendar dataNascimento = new Calendar(format.parse(dataNascimentoTexto).getTime());
		//System.out.println(dataNascimento);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

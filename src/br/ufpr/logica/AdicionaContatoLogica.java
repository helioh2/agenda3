package br.ufpr.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;

public class AdicionaContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		return "/WEB-INF/jsp/contato-adicionado.jsp";
		
	}

}

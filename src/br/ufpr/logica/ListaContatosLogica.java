package br.ufpr.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;

public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		ContatoDao dao  = new ContatoDao(conexao);
		List<Contato> contatos = dao.getLista();
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/listar-contatos.jsp";
	}

}

package br.ufpr.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		ContatoDao dao  = new ContatoDao(conexao);
		dao.remove(contato);

		return "mvc?logica=ListaContatosLogica";
	}

}

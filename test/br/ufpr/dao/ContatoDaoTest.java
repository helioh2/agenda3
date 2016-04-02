package br.ufpr.dao;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import br.ufpr.modelo.Contato;

public class ContatoDaoTest {

	@Test
	public void test() {
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = 
				new Contato("helio1", 
						"heliohenrique@ufpr.br", 
						"lupicinio1", 
						Calendar.getInstance());
		
		contatoDao.adiciona(contato);
		
	}

}

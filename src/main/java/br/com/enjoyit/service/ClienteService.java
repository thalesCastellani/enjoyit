package br.com.enjoyit.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;

import br.com.enjoyit.dao.ClienteDao;
import br.com.enjoyit.exception.TelefoneInvalidoException;
import br.com.enjoyit.model.Cliente;

public class ClienteService {
	
	private ClienteDao clienteDao;
	
	public ClienteService(EntityManager em) {
		clienteDao = new ClienteDao(em);
	}
	
	public void cadastra(Cliente cliente) throws TelefoneInvalidoException {
		valida(cliente);
		clienteDao.cadastra(cliente);
	}
	
	private void valida(Cliente cliente) throws TelefoneInvalidoException {
		Pattern pattern = Pattern.compile("");
		Matcher matcher = pattern.matcher("11945452200");
		
		// continuar implementacao
		
	}

}

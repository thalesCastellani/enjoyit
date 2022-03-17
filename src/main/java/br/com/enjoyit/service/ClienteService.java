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
	
	public Cliente buscaPorTelefone(String telefone) throws TelefoneInvalidoException {
		valida(telefone);
		return clienteDao.buscaPorTelefone(telefone);
	}
	
	private void valida(String telefone) throws TelefoneInvalidoException {
		String regex = "^((\\(\\d{2}\\))|\\d{2})[- .]?\\d{5}[- .]?\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telefone);
		
		boolean encontrou = matcher.matches();
		
		if (!encontrou) {
			throw new TelefoneInvalidoException();
		}
		
	}

}

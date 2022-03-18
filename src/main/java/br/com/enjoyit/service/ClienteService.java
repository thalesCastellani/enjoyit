package br.com.enjoyit.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;

import br.com.enjoyit.dao.ClienteDao;
import br.com.enjoyit.exception.TelefoneInvalidoException;
import br.com.enjoyit.model.Cliente;

/**
 * Classe de servi�o que cont�m as regras de neg�cio e valida��es da interface
 * com o Cliente
 * 
 * @author Os Renegados
 */
public class ClienteService {

	private ClienteDao clienteDao;

	/**
	 * Construtor que recebe o Entity Manager como inje��o de depend�ncia
	 * 
	 * @param EntityManager em
	 */
	public ClienteService(EntityManager em) {
		clienteDao = new ClienteDao(em);
	}

	/**
	 * Invoca o metodo valida que faz a valida��o do telefone informado no input e
	 * caso seja v�lido invoca o m�todo buscaPorTelefone do clienteDao que busca um
	 * cliente cadastrado no banco de dados pelos seu telefone, caso seja inv�lido,
	 * lan�a uma TelefoneInvalidoException
	 * 
	 * @param String telefone
	 * 
	 * @throws TelefoneInvalidoException
	 */
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

package br.com.enjoyit.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.enjoyit.model.Cliente;

/**
 * Classe que realiza as operações básicas com o Cliente no banco de dados
 * 
 * @author Os Renegados
 */
public class ClienteDao {

	private EntityManager em;

	/**
	 * Construtor que recebe o Entity Manager como injeção de dependência
	 * 
	 * @param EntityManager em
	 */
	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Cadastra um novo cliente no banco de dados
	 * 
	 * @param Cliente cliente com os valores que serão cadastrados
	 */
	public void cadastra(Cliente cliente) {
		this.em.persist(cliente);
	}

	/**
	 * Retorna todos os clientes do banco de dados
	 * 
	 * @return List<Cliente> Lista de clientes
	 */
	public List<Cliente> buscaTodosOsClientes() {
		String jpql = "SELECT c FROM Cliente c ";
		return this.em.createQuery(jpql, Cliente.class).getResultList();
	}

	/**
	 * Retorna um cliente do banco de dados pelo seu telefone
	 * 
	 * @return Cliente cliente
	 */
	public Cliente buscaPorTelefone(String telefone) {
		String jpql = "SELECT c FROM Cliente c WHERE c.telefone = :telefone";
		return this.em.createQuery(jpql, Cliente.class).setParameter("telefone", telefone).getSingleResult();
	}

}

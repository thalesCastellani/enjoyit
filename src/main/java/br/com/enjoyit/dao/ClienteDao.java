package br.com.enjoyit.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.enjoyit.model.Cliente;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void cadastra(Cliente cliente) {
		this.em.persist(cliente);
	}

	public List<Cliente> buscaTodosOsClientes() {
		String jpql = "SELECT c FROM Cliente c ";
		return this.em.createQuery(jpql, Cliente.class).getResultList();
	}

	public Cliente buscaPorTelefone(String telefone) {
		String jpql = "SELECT c FROM Cliente c WHERE c.telefone = :telefone";
		return this.em.createQuery(jpql, Cliente.class).setParameter("telefone", telefone).getSingleResult();
	}

}

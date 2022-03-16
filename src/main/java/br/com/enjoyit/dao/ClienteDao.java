package br.com.enjoyit.dao;

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

}

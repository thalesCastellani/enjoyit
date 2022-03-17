package br.com.enjoyit.dao;

import javax.persistence.EntityManager;

import br.com.enjoyit.model.Bebida;

public class BebidaDao {
	
	private EntityManager em;
	
	public BebidaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastra(Bebida bebida) {
		this.em.persist(bebida);
	}
	
	public Bebida buscaPorId(Long id) {
		return this.em.find(Bebida.class, id);
	}

}

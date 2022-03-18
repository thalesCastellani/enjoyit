package br.com.enjoyit.dao;

import javax.persistence.EntityManager;

import br.com.enjoyit.model.Bebida;

/**
 * Classe que realiza as operações básicas com a Bebida no banco de dados
 * 
 * @author Os Renegados
 */
public class BebidaDao {

	private EntityManager em;

	/**
	 * Construtor que recebe o Entity Manager como injeção de dependência
	 * 
	 * @param EntityManager em
	 */
	public BebidaDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Cadastra uma nova bebida no banco de dados
	 * 
	 * @param Bebida bebida com os valores que serão cadastrados
	 */
	public void cadastra(Bebida bebida) {
		this.em.persist(bebida);
	}

	/**
	 * Retorna uma bebida do banco de dados pelo seu id
	 * 
	 * @return Bebida bebida
	 */
	public Bebida buscaPorId(Long id) {
		return this.em.find(Bebida.class, id);
	}

}

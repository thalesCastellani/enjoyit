package br.com.enjoyit.dao;

import javax.persistence.EntityManager;

import br.com.enjoyit.model.Bebida;

/**
 * Classe que realiza as opera��es b�sicas com a Bebida no banco de dados
 * 
 * @author Os Renegados
 */
public class BebidaDao {

	private EntityManager em;

	/**
	 * Construtor que recebe o Entity Manager como inje��o de depend�ncia
	 * 
	 * @param EntityManager em
	 */
	public BebidaDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Cadastra uma nova bebida no banco de dados
	 * 
	 * @param Bebida bebida com os valores que ser�o cadastrados
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

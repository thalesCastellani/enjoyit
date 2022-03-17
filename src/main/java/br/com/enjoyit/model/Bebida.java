package br.com.enjoyit.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EI_BEBIDA")
@SequenceGenerator(name = "bebida", sequenceName = "SQ_TB_BEBIDA", allocationSize = 1)
public class Bebida {

	@Id
	@Column(name = "id_bebida")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bebida")
	private Long id;

	@Column(name = "nm_bebida")
	private String nome;

	@Column(name = "es_bebida")
	private String estilo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "Bebida [id=" + id + ", nome=" + nome + ", estilo=" + estilo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estilo, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebida other = (Bebida) obj;
		return Objects.equals(estilo, other.estilo) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}

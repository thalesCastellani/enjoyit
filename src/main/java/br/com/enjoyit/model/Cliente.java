package br.com.enjoyit.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_EI_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private Long id;

	@Column(name = "nr_telefone", nullable = false, unique = true)
	private String telefone;

	@Column(name = "nm_cliente")
	private String nome;

	@Column(name = "dt_ultima_visita")
	@JsonProperty("data_ultima_visita")
	private String dataUltimaVisita;

	@Column(name = "fq_visitas")
	@JsonProperty("frequencia_dias_no_mes")
	private Integer frequencia;

	@Column(name = "vl_ticket_medio")
	@JsonProperty("ticket_medio")
	private BigDecimal ticketMedio;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Bebida> bebidas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataUltimaVisita() {
		return dataUltimaVisita;
	}

	public void setDataUltimaVisita(String dataUltimaVisita) {
		this.dataUltimaVisita = dataUltimaVisita;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

	public BigDecimal getTicketMedio() {
		return ticketMedio;
	}

	public void setTicketMedio(BigDecimal ticketMedio) {
		this.ticketMedio = ticketMedio;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", telefone=" + telefone + ", nome=" + nome + ", dataUltimaVisita="
				+ dataUltimaVisita + ", frequencia=" + frequencia + ", ticketMedio=" + ticketMedio + ", bebidas="
				+ bebidas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bebidas, dataUltimaVisita, frequencia, id, nome, telefone, ticketMedio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(bebidas, other.bebidas) && Objects.equals(dataUltimaVisita, other.dataUltimaVisita)
				&& Objects.equals(frequencia, other.frequencia) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone)
				&& Objects.equals(ticketMedio, other.ticketMedio);
	}

}

package br.com.enjoyit.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
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
	private LocalDateTime dataUltimaVisita = LocalDateTime.now();

	@Column(name = "fq_visitas")
	private Integer frequencia;

	@Column(name = "vl_ticket_medio")
	private BigDecimal ticketMedio;

	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name = "nm_bebida_favorita")
	@JoinTable(joinColumns = @JoinColumn(name = "id_cliente"), inverseJoinColumns = @JoinColumn(name = "id_bebida"), name = "bebida_favorita_cliente")
	private List<Bebida> bebidasFavoritas;

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

	public LocalDateTime getDataUltimaVisita() {
		return dataUltimaVisita;
	}

	public void setDataUltimaVisita(LocalDateTime dataUltimaVisita) {
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

	public List<Bebida> getBebidasFavoritas() {
		return bebidasFavoritas;
	}

	public void setBebidasFavoritas(List<Bebida> bebidasFavoritas) {
		this.bebidasFavoritas = bebidasFavoritas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", telefone=" + telefone + ", nome=" + nome + ", dataUltimaVisita="
				+ dataUltimaVisita + ", frequencia=" + frequencia + ", ticketMedio=" + ticketMedio
				+ ", bebidasFavoritas=" + bebidasFavoritas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bebidasFavoritas, dataUltimaVisita, frequencia, id, nome, telefone, ticketMedio);
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
		return Objects.equals(bebidasFavoritas, other.bebidasFavoritas)
				&& Objects.equals(dataUltimaVisita, other.dataUltimaVisita)
				&& Objects.equals(frequencia, other.frequencia) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone)
				&& Objects.equals(ticketMedio, other.ticketMedio);
	}

}

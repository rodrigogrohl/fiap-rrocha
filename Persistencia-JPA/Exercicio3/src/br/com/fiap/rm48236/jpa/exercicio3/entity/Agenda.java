package br.com.fiap.rm48236.jpa.exercicio3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AGENDA")
public class Agenda implements Serializable {

	private static final long serialVersionUID = -5528600103156837664L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AGENDA_PACIENTE", 
		catalog="HOSPITAL",
		joinColumns = {@JoinColumn(name="AGENDA_ID", nullable=false, updatable=false)},
		inverseJoinColumns = {@JoinColumn(name="PACIENTE_CPF", nullable=false, updatable=false)},
		uniqueConstraints= @UniqueConstraint(columnNames={"AGENDA_ID","PACIENTE_CPF"},name="CONSTRAINT_AGENDA_PACIENTE")
	)
	private List<Paciente> pacientes;

	@Column(name = "DATA")
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "HORA")
	@Temporal(TemporalType.TIME)
	private Date hora;

	@Column(name = "DESCRICAO")
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Paciente> getPacientes() {
		if(pacientes == null)
			pacientes = new ArrayList<>();
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public Agenda() {}

	public Agenda(Integer id, Date data, Date hora, String descricao) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "id=" + id + ", data=" + data + ", hora=" + hora + ", descricao=" + descricao ;
	}
	
}

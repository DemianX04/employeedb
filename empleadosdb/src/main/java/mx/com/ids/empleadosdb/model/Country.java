package mx.com.ids.empleadosdb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "id")
	private Employee id;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long code;
	
	
	private String nombre;


	public Employee getId() {
		return id;
	}


	public void setId(Employee id) {
		this.id = id;
	}


	public Long getCodigo() {
		return code;
	}


	public void setCodigo(Long codigo) {
		this.code = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

	public Country() {
		super();
	}


	public Country(String nombre) {
		super();
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", codigo=" + code + ", nombre=" + nombre + "]";
	}
	
	
}

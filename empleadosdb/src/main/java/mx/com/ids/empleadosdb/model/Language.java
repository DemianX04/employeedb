package mx.com.ids.empleadosdb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "id")
	private Employee id;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private String lenguaje;

	public Employee getId() {
		return id;
	}

	public void setId(Employee id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", codigo=" + codigo + ", lenguaje=" + lenguaje + "]";
	}
	
	
	

}

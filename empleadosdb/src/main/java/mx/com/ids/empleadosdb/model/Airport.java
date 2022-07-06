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
@Table(name = "airport")
public class Airport implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "code")
	private Country id;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "airport")
	private String name;


	public Country getId() {
		return id;
	}


	public void setId(Country id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	

	public Airport(String name) {
		super();
		this.name = name;
	}

	
	

	public Airport() {
		super();
	}


	@Override
	public String toString() {
		return "Airport [id=" + id + ", codigo=" + name + "]";
	}
	
	

}

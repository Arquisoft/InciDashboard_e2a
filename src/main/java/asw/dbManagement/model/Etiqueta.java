package asw.dbManagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIncidence")
public class Etiqueta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	Etiqueta() {
	}
	@ManyToMany
	private Set<Incidence> incidencias = new HashSet<>();
	
	private String valor;

	public Long getId() {
		return id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Incidence> getIncidencias() {
		return incidencias;
	}
	public void setIncidencias(Set<Incidence> incidencias) {
		this.incidencias = incidencias;
	}
	public Etiqueta(Set<Incidence> incidencias, String valor) {
		super();
		this.incidencias = incidencias;
		this.valor = valor;
	}
	
	
	

}

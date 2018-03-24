package asw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Campo {
	
	@Id @GeneratedValue Long id;
	
	@ManyToOne
	private Incidence incidencia;
	
	private String clave;
	private String valor;
	
	public Campo() {
		
	}
	
	public Campo(String clave, String valor) {
		this.clave = clave;
		this.valor = valor;
	}
	
	public Campo(String clave, String valor, Incidence i)
	{
		this(clave, valor);
		this.incidencia = i;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Incidence getincidencia() {
		return incidencia;
	}
	
	public void setincidencia(Incidence incidencia) {
		this.incidencia = incidencia;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
}

}

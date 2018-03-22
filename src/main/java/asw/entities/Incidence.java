package asw.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import asw.dbManagement.model.types.Status;

@Entity
@Table(name = "TIncidence")
public class Incidence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreUsuario;
	private String nombreIncidencia;
	private String descripcion;
	private String localizacion;
	private Object info;
	@ManyToOne private Agent agente;
	private Status status;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
        name = "Incidencia_Etiquetas", 
        joinColumns = { @JoinColumn(name = "incidence_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "etiqueta_id") }
	)
	private Set<Etiqueta> etiquetas = new HashSet<>();
	
	private Set<Campo> campos = new HashSet<>(); 
	
	public Incidence() { }
	
	public Incidence(String nombreUsuario, String nombreIncidencia, String descripcion,
			String localizacion, Set<Etiqueta> etiquetas, Object info, Set<Campo> campos, Status status) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombreIncidencia = nombreIncidencia;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
		this.etiquetas = etiquetas;
		this.info = info;
		this.campos = campos;
		this.status = status;
	}

	public String getdescripcion() {
		return descripcion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreIncidencia() {
		return nombreIncidencia;
	}

	public void setNombreIncidencia(String nombreIncidencia) {
		this.nombreIncidencia = nombreIncidencia;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Set<Etiqueta> getEtiquetas() {
		return new HashSet<Etiqueta>(etiquetas);
		
	}
	
	Set<Etiqueta> _getEtiquetas() {
		return etiquetas;
	}

	void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidence other = (Incidence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public Agent getAgente() {
		return agente;
	}

	public void setAgente(Agent agente) {
		this.agente = agente;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Incidence [nombreUsuario=" + nombreUsuario + ", nombreIncidencia="
				+ nombreIncidencia + ", descripcion=" + descripcion + ", localizacion=" + localizacion + ", etiquetas="
				+ etiquetas + ", info=" + info + ", campos=" + campos + ", agente=" + agente + ", status="
				+ status + "]";
	}

}

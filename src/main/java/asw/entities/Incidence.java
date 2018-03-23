package asw.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TIncidence")
public class Incidence {

	@Id @GeneratedValue Long id;
	
	@ManyToOne
	private Agent agent;
	
	private String nombre;
	private String descripcion;
	
	private String localizacion;
	
	@OneToMany(mappedBy="incidencia")
	private Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	
	@OneToMany(mappedBy="incidencia")
	private Set<Campo> campos = new HashSet<Campo>(); //propiedad/valor
	
	@Enumerated(EnumType.STRING)
	private Status estado;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date caducidad;
	
	private String entidadAsignada;
	private String comentarioOperario;
	
	@ManyToOne
	private Operator operadorAsignado;
	
	public Incidence() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Set<Campo> getCampos() {
		return campos;
	}

	public void setCampos(Set<Campo> campos) {
		this.campos = campos;
	}

	public Status getEstado() {
		return estado;
	}

	public void setEstado(Status estado) {
		this.estado = estado;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public String getEntidadAsignada() {
		return entidadAsignada;
	}

	public void setEntidadAsignada(String entidadAsignada) {
		this.entidadAsignada = entidadAsignada;
	}

	public String getComentarioOperario() {
		return comentarioOperario;
	}

	public void setComentarioOperario(String comentarioOperario) {
		this.comentarioOperario = comentarioOperario;
	}

	public Operator getOperadorAsignado() {
		return operadorAsignado;
	}

	public void setOperadorAsignado(Operator operadorAsignado) {
		this.operadorAsignado = operadorAsignado;
	}
	

}
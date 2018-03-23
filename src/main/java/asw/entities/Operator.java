package asw.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TOperator")
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ID;
	
	private String name;
	private String password;
	private String numeroIncidencias;
	
	@OneToMany(mappedBy = "operatorAsignado", cascade = CascadeType.ALL)
	private Set<Incidence> incidencias = new HashSet<>();
	
	public Operator() {}

	public Operator(String name, String password, String numeroIncidencias, Set<Incidence> incidencias) {
		super();
		this.name = name;
		this.password = password;
		this.numeroIncidencias = numeroIncidencias;
		this.incidencias = incidencias;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumeroIncidencias() {
		return numeroIncidencias;
	}

	public void setNumeroIncidencias(String numeroIncidencias) {
		this.numeroIncidencias = numeroIncidencias;
	}

	public Set<Incidence> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidence> incidencias) {
		this.incidencias = incidencias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		Operator other = (Operator) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operator [ID=" + ID + ", name=" + name + ", password=" + password + ", numeroIncidencias="
				+ numeroIncidencias + ", incidencias=" + incidencias + "]";
	}
	
	
	

}

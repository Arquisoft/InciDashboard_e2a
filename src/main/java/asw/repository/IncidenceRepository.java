package asw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.Incidence;

@Repository
public interface IncidenceRepository extends CrudRepository<Incidence, Long>{
	
	public Incidence findByIdentificador(String identificador);
	

}

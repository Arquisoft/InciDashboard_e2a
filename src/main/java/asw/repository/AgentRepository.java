package asw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.Agent;
import asw.entities.Incidence;

@Repository
public interface AgentRepository extends CrudRepository<Incidence, Long>{
	
	Agent findByName(String name);

}

package asw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.CamposCriticos;

@Repository
public interface CamposCriticosRepository extends CrudRepository<CamposCriticos, Long>
{
	CamposCriticos findByCampo(String campo);
	List<CamposCriticos> findAll();
} 

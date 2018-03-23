package asw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.entities.Operator;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long>
{
	Operator findByUser(String username);
}

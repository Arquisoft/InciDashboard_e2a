package asw.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import asw.entities.Operator;
import asw.repository.OperatorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperatorRepository operatorRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void addOperator(Operator operator) {
		operator.setPassword(bCryptPasswordEncoder.encode(operator.getPassword()));
		operatorRepository.save(operator);
	}
	
	public void actualizarOperario(Operator op)
	{
		operatorRepository.save( op );
	}
	
	public Operator obtainOperatorForIncidence() {
		List<Operator> list = operatorRepository.findAll();
		Collections.sort(list, new Comparator<Operator>() {
		    @Override
		    public int compare(Operator o1, Operator o2) {
		        return o1.getNumeroIncidencias() - o2.getNumeroIncidencias();
		    }
		});
		return list.get(0);
	}
	
	public Operator getOperatorByName(String name) {
		return operatorRepository.findByUser(name);
	}
}

package asw.services;

import java.util.ArrayList;
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
	
	public List<Operator> findAllOperators() {
		List<Operator> operarios = new ArrayList<Operator>();
		operatorRepository.findAll().forEach(operarios::add);
		
		return operarios;
	}
	
	public void actualizarOperario(Operator op)
	{
		operatorRepository.save( op );
	}
}

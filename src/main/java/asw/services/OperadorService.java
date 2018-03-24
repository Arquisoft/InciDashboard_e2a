package asw.services;

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
}

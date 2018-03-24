package asw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import asw.entities.CamposCriticos;
import asw.entities.Operator;
import asw.repository.CamposCriticosRepository;
import asw.repository.OperatorRepository;

@Service
public class CamposCriticosService {
	
	@Autowired
	private CamposCriticosRepository ccRepository;
	
	
	public List<CamposCriticos> getAll(){
		List<CamposCriticos> campos = new ArrayList<>();
		ccRepository.findAll().forEach(campos::add);
		return campos;
	}

	
}

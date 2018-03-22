package asw.dbManagement.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.GetIncidence;
import asw.dbManagement.model.Incidence;
import asw.dbManagement.repository.IncidenceRepository;

@Service
public class GetIncidenceImpl implements GetIncidence{

	private IncidenceRepository repository;
	
	@Autowired
	public GetIncidenceImpl(IncidenceRepository repository) {
		this.repository = repository;
	}
	@Override
	public Incidence getIncidence(String identificador) {
		return this.repository.findByIdentificador(identificador);
	}

}

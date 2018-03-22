package asw.dbManagement.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.GetAllIncidences;
import asw.dbManagement.model.Incidence;
import asw.dbManagement.repository.IncidenceRepository;

@Service
public class GetAllIncidencesImpl implements GetAllIncidences{

	private IncidenceRepository repository;
	
	@Autowired
	public GetAllIncidencesImpl(IncidenceRepository repository) {
		this.repository = repository;
	}
	@Override
	public List<Incidence> getIncidence() {
		return this.repository.findAll();
	}

}

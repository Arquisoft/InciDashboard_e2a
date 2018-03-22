package asw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.entities.Incidence;
import asw.repository.GetAllIncidences;
import asw.repository.IncidenceRepository;

@Service
public class GetAllIncidencesImpl implements GetAllIncidences{

	private IncidenceRepository incidenceRepository;
	
	@Autowired
	public GetAllIncidencesImpl(IncidenceRepository repository) {
		this.incidenceRepository = repository;
	}
	@Override
	public List<Incidence> getIncidences() {
		List<Incidence> incidencias = new ArrayList<Incidence>();
		incidenceRepository.findAll().forEach(incidencias::add);
		
		return incidencias;
	}

}

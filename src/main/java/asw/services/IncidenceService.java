package asw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.entities.Incidence;
import asw.repository.IncidenceRepository;

@Service
public class IncidenceService {
	
	@Autowired
	public IncidenceRepository inciRepository;
	
	public Incidence getIncidence(Long identificador) {
		return inciRepository.findOne( identificador );
	}
	
	public List<Incidence> getIncidences() {
		List<Incidence> incidencias = new ArrayList<Incidence>();
		inciRepository.findAll().forEach(incidencias::add);
		
		return incidencias;
	}
}

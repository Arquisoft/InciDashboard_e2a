package asw.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.entities.Campo;
import asw.entities.Incidence;
import asw.entities.Location;
import asw.repository.CamposRepository;
import asw.repository.IncidenceRepository;
import asw.repository.LocationRepository;

@Service
public class IncidenceService {
	
	@Autowired
	public IncidenceRepository inciRepository;
	
	@Autowired
	public CamposRepository camposRepository;
	
	@Autowired
	LocationRepository locRepo;
	
	public void addIncidence(Incidence incidence)
	{
		inciRepository.save( incidence );
	}
	
	public Incidence getIncidence(Long identificador) {
		return inciRepository.findOne( identificador );
	}
	
	public List<Incidence> getIncidences() {
		List<Incidence> incidencias = new ArrayList<Incidence>();
		inciRepository.findAll().forEach(incidencias::add);
		
		return incidencias;
	}
	
	public void addCampos(Set<Campo> campos)
	{
		for (Campo c : campos)
		{
			camposRepository.save( c );
		}
	}
	
	public void addCamposAIncidencia(Incidence i, Set<Campo> campos)
	{
		for(Campo c : campos)
		{
			i.addCampo( c );
			c.setincidencia( i );
		}
	}
	
	public void addLocation(Location loc)
	{
		locRepo.save( loc );
	}
}

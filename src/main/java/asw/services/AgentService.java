package asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import asw.entities.Agent;
import asw.entities.Location;
import asw.repository.AgentRepository;
import asw.repository.LocationRepository;

@Service
public class AgentService {
	
	@Autowired
	AgentRepository agentRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Agent findByName(String name) {
		return agentRepo.findByNombre(name);
	}
		
	public void addAgent(Agent agent) {
		agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
		agentRepo.save(agent);
	}
	
	public void actualizarAgente(Agent agente)
	{
		agentRepo.save( agente );
	}
	
}

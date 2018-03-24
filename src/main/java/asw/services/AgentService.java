package asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import asw.entities.Agent;
import asw.repository.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
	private AgentRepository agentsRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void addAgent(Agent agent) {
		agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
		agentsRepository.save(agent);
	}
	
	public void actualizarAgente(Agent agente)
	{
		agentsRepository.save( agente );
	}
}

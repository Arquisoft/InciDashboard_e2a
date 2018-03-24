package asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.entities.Agent;
import asw.repository.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
	AgentRepository agentRepo;
	
	public Agent findByName(String name) {
		return agentRepo.findByName(name);
	}
}

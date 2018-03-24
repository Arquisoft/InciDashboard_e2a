package asw.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import asw.Application;
import asw.streamKafka.productor.Topics;

@Controller
public class DashboardAdminController {
/*	@Autowired
	private IncidenceRepository incidenceRepository; */
	private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());

	// Inicio del dashboard que muestra las incidencias
/*	@RequestMapping("/dashboardAdmin")
	public String showIncidenes(Model model) {
		model.addAttribute("allIncidences", incidenceRepository.findAll());
		return "dashboardIncidences";
	}*/

	@RequestMapping(value = "/newIncidence")
	@KafkaListener(topics = Topics.NEW_INCIDENCE)
	public void newIncidence(String data) {
		SseEventBuilder event = SseEmitter.event().name("newIncidence").data(data);
		sendData(event); 
	}
	
	void sendData(SseEventBuilder event) {
		synchronized (this.sseEmitters) {
			for (SseEmitter sseEmitter : this.sseEmitters) {
				try {
					sseEmitter.send(event);
				} catch (IOException e) {
					sseEmitter = new SseEmitter(Long.MAX_VALUE);
					Application.logger.error("Se ha cerrado el stream actual");
				}
			}
		}
	}
	
	@RequestMapping("/getEmitter")
	public SseEmitter getEmitter() {
		return newEmitter();
	}

	public SseEmitter newEmitter() {
		
		SseEmitter emitter = new SseEmitter(0L);
		this.sseEmitters.add(emitter);
		
		emitter.onCompletion(() -> this.sseEmitters.remove(emitter));
		emitter.onTimeout(() -> this.sseEmitters.remove(emitter));
		
		return emitter;

	
	
	}
}



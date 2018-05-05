package asw.streamKafka.consumidor;


import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import asw.controllers.DashboardAdminController;
import asw.parser.ParserIncidencia;
import asw.streamKafka.Topics;


@ManagedBean
public class KafkaConsumer {

	@Autowired
	DashboardAdminController dsController;
	
	@Autowired
	ParserIncidencia parserInci;

    @KafkaListener(topics = Topics.incidencias)
    public void listen(String data) {
    	System.out.println(data);
    	
       	String incidencia = parserInci.parseToIncidence( data );
      
        SseEventBuilder evento = SseEmitter.event().name((Topics.incidencias)).data( incidencia );
        this.dsController.sendData(evento);
      
    }
}

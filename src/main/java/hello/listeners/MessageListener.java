package hello.listeners;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import asw.entities.Incidence;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {

	private static final Logger logger = Logger.getLogger(MessageListener.class);

    @KafkaListener(topics = "newIncidence")
    public void listen(String data) {
        logger.info("New message received: \"" + data + "\"");
    }
    
    public void parseToIncidence(String data) {
    	//NombreUsuario@nombreIncidencia@descripcion@localizacion@etiquetas_#1
    	//@informacionAdicional_#2@listaCampos_#3
    	//@estado@entidadAsignada@comentarioOperario@caducidad
    	
    	String[] camposSeparados=separaCampos(data);
    	Incidence incidence=new Incidence();
    	//agent
    	incidence.setNombre(camposSeparados[0]);
    	//nombreIncidencia
    	
    	
    }
    
    private String[] separaCampos(String data) {
    	String[] aux = data.split("@");
    	return aux;
    }
    



}

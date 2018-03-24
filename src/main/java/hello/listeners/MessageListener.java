package hello.listeners;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import asw.entities.Campo;
import asw.entities.Etiqueta;
import asw.entities.Incidence;
import asw.entities.Status;
import asw.services.AgentService;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {
	
	@Autowired
	AgentService agentService;

	private static final Logger logger = Logger.getLogger(MessageListener.class);

    @KafkaListener(topics = "newIncidence")
    public void listen(String data) {
        logger.info("New message received: \"" + data + "\"");
    }
    
    public void parseToIncidence(String data) {
    	//NombreUsuario@nombreIncidencia@descripcion@localizacion@etiquetas_#1
    	//@listaCampos_#3@estado@entidadAsignada@comentarioOperario@caducidad
    	
    	String[] camposSeparados=separaCampos(data);
    	Incidence incidence=new Incidence();
    	//agent
    	incidence.setAgent(agentService.findByName(camposSeparados[0]));
    	//nombreIncidencia
    	incidence.setNombre(camposSeparados[1]);
    	//descripcion
    	incidence.setDescripcion(camposSeparados[2]);
    	//localizacion
    	incidence.setLocalizacion(camposSeparados[3]);
    	//etiquetas
    	incidence.setEtiquetas(etiquetas(camposSeparados[4]));
    	//lista de campos
    	incidence.setCampos(listaCampos(camposSeparados[5]));
    	//estado
    	incidence.setEstado(Status.ABIERTO);
    	//comentario operario
    	incidence.setOperadorAsignado(null);
    	//caducidad falta el parseo a date
    	incidence.setCaducidad(parseFecha(camposSeparados[7]));
    	
    	
    }
    
    private String[] separaCampos(String data) {
    	String[] aux = data.split("@");
    	return aux;
    }
    

    private Set<Etiqueta> etiquetas(String etiquetas){
    	HashSet<Etiqueta> set=new HashSet<Etiqueta>();
    	String[] aux = etiquetas.split("$");
    	for(String s:aux) {
    		Etiqueta etiqueta=new Etiqueta();
    		etiqueta.setValor(s);
    		set.add(etiqueta);
    	}
    	return set;
    }
    
    
    
    private Set<Campo> listaCampos(String campos){
    	HashSet<Campo> set=new HashSet<Campo>();
    	String[] aux = campos.split("$");
    	for(String s: aux) {
    		set.add(claveValor(s));
    	}
    	return set;
    }

	private Campo claveValor(String s) {
		Campo campo=new Campo();
		String[] aux = s.split(",");
		campo.setClave(aux[0]);
		campo.setValor(aux[1]);
		return campo;
		
	}
    
	public static Date parseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    

}

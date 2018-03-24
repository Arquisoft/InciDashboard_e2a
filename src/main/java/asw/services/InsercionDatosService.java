/*package asw.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.entities.Agent;
import asw.entities.Campo;
import asw.entities.Incidence;
import asw.entities.Operator;
import asw.entities.Status;

@Service
public class InsercionDatosService 
{
	@Autowired
	private AgentService agentsService;
	
	@Autowired
	private OperadorService operadoresService;
	
	@Autowired
	private IncidenceService inciService;
	
	@SuppressWarnings("serial")
	@PostConstruct
	public void init() {
		// Creamos los agentes y operarios y los añadimos a la bbdd
		Agent agente1 = new Agent("agente1", "Pepe", "123456", "prueba@hotmail.com", 1);
		Agent agente2 = new Agent("agente2", "Juan", "123456", "prueba@hotmail.com", 1); 
		Agent agente3 = new Agent("agente3", "Alberta", "123456", "prueba@hotmail.com", 1);
		agentsService.addAgent( agente1 );
		agentsService.addAgent( agente2 );
		agentsService.addAgent( agente3 );
		
		Operator op1 = new Operator("Pablo", "123456"); 
		Operator op2 = new Operator("Pepe", "123456"); 
		Operator op3 = new Operator("Juan", "123456"); 
		operadoresService.addOperator( op1 );
		operadoresService.addOperator( op2 );
		operadoresService.addOperator( op3 );
		
		// Creamos las incidencias
		Incidence inc1 = new Incidence("Incidencia 1", "12.1023, 33.100", agente1, Status.ABIERTO);
		Incidence inc2 = new Incidence("Incidencia 2", "-45.90003, 11.933", agente1, Status.CERRADO);
		Incidence inc3 = new Incidence("Incidencia 3", "-31.9503, 31.9373", agente2, Status.ANULADA);
		Incidence inc4 = new Incidence("Incidencia 4", "-1.094, -33.02", agente2, Status.ABIERTO);
		Incidence inc5 = new Incidence("Incidencia 5", "49.0239, -49.7199", agente3, Status.EN_PROCESO);
		Incidence inc6 = new Incidence("Incidencia 6", "0.94851, -5.0911", agente3, Status.ABIERTO);
		
		// Creamos campos para incidencias y los añadimos a la bbdd
		Campo c1 = new Campo("propiedad", "valor");
		Campo c2 = new Campo("nombre", "pablo");
		Campo c3 = new Campo("apellido", "diaz");
		Campo c4 = new Campo("ciudad", "gijon");
		Campo c5 = new Campo("estudia", "informatica");
		Campo c6 = new Campo("curso", "tercero");
		Campo c7 = new Campo("lugar", "oviedo");
		Campo c8 = new Campo("prueba", "valor prueba");
		Campo c9 = new Campo("propiedad", "de otra prueba");
		Campo c10 = new Campo("asignatura", "ASW");
		
		Set<Campo> campos1 = new HashSet<Campo>() {{ add(c1); add(c2); }};
		Set<Campo> campos2 = new HashSet<Campo>() {{ add(c3); }};
		Set<Campo> campos3 = new HashSet<Campo>() {{ add(c4); add(c5); add(c6); }};
		Set<Campo> campos4 = new HashSet<Campo>() {{ add(c7); }};
		Set<Campo> campos5 = new HashSet<Campo>() {{ add(c8); }};
		Set<Campo> campos6 = new HashSet<Campo>() {{ add(c9); add(c10); }};
		
		inciService.addCampos( campos1 );
		inciService.addCampos( campos2 );
		inciService.addCampos( campos3 );
		inciService.addCampos( campos4 );
		inciService.addCampos( campos5 );
		inciService.addCampos( campos6 );
		
		// Asignamos campos a incidencias
		inciService.addCamposAIncidencia(inc1, campos1);
		inciService.addCamposAIncidencia(inc2, campos2);
		inciService.addCamposAIncidencia(inc3, campos3);
		inciService.addCamposAIncidencia(inc4, campos4);
		inciService.addCamposAIncidencia(inc5, campos5);
		inciService.addCamposAIncidencia(inc6, campos6);
		
		// Añadimos incidencias en la bbdd
		inciService.addIncidence( inc1 );
		inciService.addIncidence( inc2 );
		inciService.addIncidence( inc3 );
		inciService.addIncidence( inc4 );
		inciService.addIncidence( inc5 );
		inciService.addIncidence( inc6 );
		
		inciService.addCampos( campos1 );
		inciService.addCampos( campos2 );
		inciService.addCampos( campos3 );
		inciService.addCampos( campos4 );
		inciService.addCampos( campos5 );
		inciService.addCampos( campos6 );
		
		// Actualizamos las incidencias que han mandado los agentes
		agente1.addIncidencia(inc1);
		agente1.addIncidencia(inc2);
		agente2.addIncidencia(inc3);
		agente2.addIncidencia(inc4);
		agente3.addIncidencia(inc5);
		agente3.addIncidencia(inc6);
		agentsService.actualizarAgente(agente1);
		agentsService.actualizarAgente(agente2);
		agentsService.actualizarAgente(agente3);
		
		// Actualizamos las incidencias asignadas a operarios
		inc1.setOperadorAsignado( op1 );
		inc2.setOperadorAsignado( op1 );
		inc3.setOperadorAsignado( op2 );
		inc4.setOperadorAsignado( op2 );
		inc5.setOperadorAsignado( op3 );
		inc6.setOperadorAsignado( op3 );
		inciService.addIncidence( inc1 );
		inciService.addIncidence( inc2 );
		inciService.addIncidence( inc3 );
		inciService.addIncidence( inc4 );
		inciService.addIncidence( inc5 );
		inciService.addIncidence( inc6 );
		
		op1.addIncidencia(inc1);
		op1.addIncidencia(inc2);
		op2.addIncidencia(inc3);
		op2.addIncidencia(inc4);
		op3.addIncidencia(inc5);
		op3.addIncidencia(inc6);
		operadoresService.actualizarOperario( op1 );
		operadoresService.actualizarOperario( op2 );
		operadoresService.actualizarOperario( op3 );
	}
}
*/

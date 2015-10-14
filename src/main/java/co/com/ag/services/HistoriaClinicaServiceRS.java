package co.com.ag.services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


@Path("/historiaClinica")
@Stateless
public class HistoriaClinicaServiceRS {
	
	Client client = Client.create();
	WebResource web = client.resource("http://157.253.204.45:8080/SisWeb/webresources/co.edu.uniandes.arq.exp.historia");
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{cedula}/{prioridad}") //hace referencia a /personas/{id}
	public String encontrarHistoricoPorCedula(@PathParam("cedula") String cedula,@PathParam("prioridad") String prioridad){
		if(prioridad.equals("alta")){
			
			return web.path("/cedula/"+cedula).accept(MediaType.APPLICATION_JSON).get(String.class);
			
		}else{
			return "Espere un momento";
		}
	}
	
}

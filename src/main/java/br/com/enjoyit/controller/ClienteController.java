package br.com.enjoyit.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.enjoyit.model.Cliente;

@Path("/cliente")
public class ClienteController {

	public ClienteController() {
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar() {
		return "Olá Mundo!!";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente, @Context UriInfo uriInfo) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(timestamp.getTime());
		cliente.setDataUltimaVisita(date);
		
		javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory("enjoyit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
		
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(Integer.toString(cliente.getId()));
		return Response.created(uriBuilder.build()).build();
	}

}

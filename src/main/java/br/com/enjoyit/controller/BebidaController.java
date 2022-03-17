package br.com.enjoyit.controller;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.enjoyit.dao.BebidaDao;
import br.com.enjoyit.model.Bebida;
import br.com.enjoyit.util.JPAUtil;

@Path("/bebida")
public class BebidaController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Bebida bebida, @Context UriInfo uriInfo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		BebidaDao bebidaDao = new BebidaDao(em);
		
		em.getTransaction().begin();
		bebidaDao.cadastra(bebida);
		em.getTransaction().commit();
		em.close();
		
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(Long.toString(bebida.getId()));
		return Response.created(uriBuilder.build()).build();
	}

}

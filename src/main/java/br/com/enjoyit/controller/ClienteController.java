package br.com.enjoyit.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.enjoyit.dao.BebidaDao;
import br.com.enjoyit.dao.ClienteDao;
import br.com.enjoyit.model.Bebida;
import br.com.enjoyit.model.Cliente;
import br.com.enjoyit.util.JPAUtil;

@Path("/cliente")
public class ClienteController {

	@GET
	@Path("/{telefone}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscaInfosClientePeloTelefone(@PathParam("telefone") String telefone) {
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();
		Cliente cliente = clienteDao.buscaPorTelefone(telefone);
		em.getTransaction().commit();
		em.close();

		System.out.println(cliente.getNome());
		return cliente;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente, @Context UriInfo uriInfo) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(timestamp.getTime());
		cliente.setDataUltimaVisita(date);

		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);
		BebidaDao bebidaDao = new BebidaDao(em);

		Bebida bebida1 = bebidaDao.buscaPorId(1L);
		Bebida bebida2 = bebidaDao.buscaPorId(2L);
		cliente.setBebidas(Arrays.asList(bebida1, bebida2));

		em.getTransaction().begin();
		clienteDao.cadastra(cliente);
		em.getTransaction().commit();
		em.close();

		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(Long.toString(cliente.getId()));
		return Response.created(uriBuilder.build()).build();
	}

}

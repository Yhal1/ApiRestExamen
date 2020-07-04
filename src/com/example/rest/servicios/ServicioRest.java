package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.ProveedorModel;
import com.example.rest.entidades.Proveedor;
@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private ProveedorModel daoProveedor = new ProveedorModel();

	@GET
	@Path("/proveedor")
	public Response listarProveedorTodos() {
		log.info("listar Proveedor rest ");
		return Response.ok(daoProveedor.listarProveedorTodos()).build();
	}

	@POST
	@Path("/proveedor")
	public Response registraProveedor(Proveedor obj) {
		log.info("Proveedor rol " + obj.getIdProv());
		if (daoProveedor.insertaProveedor(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/proveedor")
	public Response atualizaProveedor(Proveedor obj) {
		log.info("Actualiza proveedor " + obj.getIdProv());
		if (daoProveedor.actualizaProveedor(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/proveedor/{idproveedor}")
	public Response eliminaProveedor(@PathParam("idproveedor") int id) {
		log.info("Elimina Proveedor " + id);
		if (daoProveedor.eliminaProveedor(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
}
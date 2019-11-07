package com.intercorp.api;

import com.intercorp.service.ClienteService;
import com.intercorp.dto.Cliente;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class ClienteApi {
	
	// Inyecta mapper de Dozer
	@Autowired
	Mapper mapper;

	@RequestMapping(value="/creacliente", method=RequestMethod.POST)
	public Cliente crearCliente(@RequestBody @Valid ClienteRequest clienteRequest) throws Exception{
		// Mapeo request dto ==> entity
		Cliente cliente = mapper.map(clienteRequest, Cliente.class);
		
		// Invoca logica de negocio
		ClienteService clienteNegocio = new ClienteService();
		return clienteNegocio.crearCliente(cliente);
	}
	
	@RequestMapping(value = "/listclientes", method = RequestMethod.GET)
	public List<Cliente> getClient() throws Exception {
		ClienteService clienteNegocio = new ClienteService();
		return clienteNegocio.listar();
	}
}

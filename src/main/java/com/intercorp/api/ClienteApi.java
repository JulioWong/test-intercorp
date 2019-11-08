package com.intercorp.api;

import com.intercorp.service.ClienteService;
import com.intercorp.dto.Cliente;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="Demo cliente - Intercorp Retail", description="Crear, listar y KPIs de clientes")
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
	
	@RequestMapping(value = "/kpideclientes", method = RequestMethod.GET)
	public Map<String, String> getKpis() throws Exception {
		ClienteService clienteNegocio = new ClienteService();
		return clienteNegocio.getKpis();
	}	
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String getTest(@RequestParam(value = "name", defaultValue = "julio") String name_test) throws Exception {
//		String template = "Hello actualice, %s!";
//		return String.format(template, name_test);
//	}
}

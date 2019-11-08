package com.intercorp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intercorp.dao.DAOClienteImpl;
import com.intercorp.dto.Cliente;

public class ClienteService extends DAOClienteImpl{
	
	public Cliente crearCliente(Cliente cliente) throws Exception {
		return super.registrar(cliente);
	}
	
	public List<Cliente> listarClientes() throws Exception {
		List<Cliente> clientes = super.listar();
		return clientes;
	}
	
	public Map<String, String> getKpis() throws Exception {
		
		List<Cliente> clientes = super.listar();
		
		// Calcular promedio
		int sumEdades = 0;
		int cantidadClientes = clientes.size();
		
		for (Cliente cliente : clientes) {
			sumEdades += cliente.getEdad();
		}
	
		int promedioEdades = sumEdades / cantidadClientes;
		
		// Calcular desviacion estandar
		float varianza = 0;
		
		for (Cliente cliente : clientes) {
			varianza += Math.pow(cliente.getEdad() - promedioEdades, 2);
		}
		
		varianza = varianza / (cantidadClientes - 1);
		float desviacionEstandar = (float) Math.round(Math.sqrt(varianza));
		
		Map<String, String> kpis = new HashMap<String, String>();
		kpis.put("promedioEdad", Integer.toString(promedioEdades));
		kpis.put("desviacionEstandarEdades", String.format("%.2f", desviacionEstandar));
		return kpis;
	}
}
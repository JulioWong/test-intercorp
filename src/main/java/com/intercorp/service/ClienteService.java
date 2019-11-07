package com.intercorp.service;

import java.util.List;

import com.intercorp.dao.DAOClienteImpl;
import com.intercorp.dto.Cliente;

public class ClienteService extends DAOClienteImpl{
	
	public Cliente crearCliente(Cliente cliente) throws Exception {
		return super.registrar(cliente);
	}
	
	public List<Cliente> listarClientes() throws Exception {
		return super.listar();
	}
}
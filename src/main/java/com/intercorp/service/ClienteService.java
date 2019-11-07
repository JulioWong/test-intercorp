package com.intercorp.service;

import com.intercorp.dao.DAOClienteImpl;
import com.intercorp.dto.Cliente;

public class ClienteService {
	
	public Cliente createClient(Cliente client) throws Exception {
		DAOClienteImpl insertClient = new DAOClienteImpl();
		return insertClient.registrar(client);
	}
}
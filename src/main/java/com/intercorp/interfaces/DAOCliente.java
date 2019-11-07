package com.intercorp.interfaces;

import java.util.List;
import com.intercorp.dto.Cliente;

public interface DAOCliente {
	public List<Cliente> listar() throws Exception;
	public void registrar(Cliente client) throws Exception;	
}
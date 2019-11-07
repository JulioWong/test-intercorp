package com.intercorp.interfaces;

import java.util.List;
import com.intercorp.dto.Cliente;

public interface DAOCliente {
	public void registrar(Cliente client) throws Exception;
	public List<Cliente> listar() throws Exception;
}
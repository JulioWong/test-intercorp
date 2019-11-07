package com.intercorp.dao;

import java.util.List;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.intercorp.dto.Cliente;
import com.intercorp.interfaces.DAOCliente;

public class DAOClienteImpl implements DAOCliente {

	@Override
	public Cliente registrar(Cliente client) throws Exception {
		AmazonDynamoDB clientbuild = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(clientbuild);
		
		Cliente newClient = new Cliente();
		
		newClient.setId(UUID.randomUUID().toString());
		newClient.setNombre(client.getNombre());
		newClient.setApellido(client.getApellido());
		newClient.setEdad(client.getEdad());
		newClient.setFechaNacimiento(client.getFechaNacimiento());
		mapper.save(newClient);
		return newClient;
	}

	@Override
	public List<Cliente> listar() throws Exception {
		return null;
	}
	
}

package com.intercorp.dao;

import java.util.List;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.intercorp.dto.Cliente;
import com.intercorp.interfaces.DAOCliente;

public class DAOClienteImpl implements DAOCliente {

	@Override
	public Cliente registrar(Cliente cliente) throws Exception {
		AmazonDynamoDB clientbuild = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(clientbuild);
		
		Cliente nuevoCliente = new Cliente();
		
		nuevoCliente.setId(UUID.randomUUID().toString());
		nuevoCliente.setNombre(cliente.getNombre());
		nuevoCliente.setApellido(cliente.getApellido());
		nuevoCliente.setEdad(cliente.getEdad());
		nuevoCliente.setFechaNacimiento(cliente.getFechaNacimiento());
		mapper.save(nuevoCliente);
		return nuevoCliente;
	}

	@Override
	public List<Cliente> listar() throws Exception {
		AmazonDynamoDB clientbuild = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(clientbuild);
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		return mapper.scan(Cliente.class, scanExpression);
	}
}

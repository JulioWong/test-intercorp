package com.intercorp.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.intercorp.dto.Cliente;
import com.intercorp.interfaces.DAOCliente;

public class DAOClienteImpl implements DAOCliente {

	static final int ESPERANZA_VIDA = 75;
	
	@Override
	public Cliente registrar(Cliente cliente) throws Exception {
		// Calcular la edad y la fecha probable de muerte
		LocalDate fechaActual = LocalDate.now();
		Period period = Period.between(LocalDate.now(), LocalDate.parse(cliente.getFechaNacimiento()));
		int edad = period.getYears() * -1;
		int anosVida = ESPERANZA_VIDA - edad;
		LocalDate fechaMuerte = fechaActual.plusYears(anosVida);
		
		// Insertas en el modelo
		AmazonDynamoDB clientbuild = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(clientbuild);
		
		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setId(UUID.randomUUID().toString());
		nuevoCliente.setNombre(cliente.getNombre());
		nuevoCliente.setApellido(cliente.getApellido());
		nuevoCliente.setEdad(edad);
		nuevoCliente.setFechaNacimiento(cliente.getFechaNacimiento());
		nuevoCliente.setFechaMuerte(fechaMuerte.toString());
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

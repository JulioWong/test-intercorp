package com.intercorp.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="client")
public class Cliente {

	private String id;
	private String nombre;
	private String apellido;
	private int edad;
	private String fechaNacimiento;
	private String fechaMuerte;
	
	public Cliente() {
		// this.id = UUID.randomUUID().toString();
	}

	@DynamoDBHashKey(attributeName="id") 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName="name") 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@DynamoDBAttribute(attributeName="lastName") 
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@DynamoDBAttribute(attributeName="age")
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@DynamoDBAttribute(attributeName="birthDate")
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@DynamoDBAttribute(attributeName="deathDate")
	public String getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(String fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

}
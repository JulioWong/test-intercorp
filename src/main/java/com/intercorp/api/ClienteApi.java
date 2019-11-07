package com.intercorp.api;

import com.intercorp.dto.Cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import io.swagger.annotations.Api;




@RestController
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class ClienteApi {

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public List<Cliente> getClient() {
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		
		Cliente item = new Cliente();
		
		item.setId(UUID.randomUUID().toString());
		item.setNombre("Julio");
		item.setApellido("Wong");
		item.setEdad(28);
		item.setFechaNacimiento("1991-02-01T05:00:00Z");
		mapper.save(item);
		
		       
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

		List<Cliente> clients =  mapper.scan(Cliente.class, scanExpression);
		
		//Map<String, String> dictionary = new HashMap<String, String>();
		// dictionary.put("key", "value");
		
		return clients; 
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Date yourDate = sdf.parse("1992-07-26");
		// return new Cliente("Julio", "Wong", 28, yourDate);
	}	
}

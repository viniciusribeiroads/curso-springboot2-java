package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController // Anotacao pra dizer que e um controlador Rest
@RequestMapping(value = "/orders") // Indica caminho
public class OrderResource {

	// Camada de recursos
	@Autowired // Spring faz a injecao de dependencia
	private OrderService service;

	// Retorna um tipo especifico do Spring pra retornar respostas de requisicoes
	// Web
	@GetMapping // anotation que indica que responde requisicao do tipo Get do http
	public ResponseEntity<List<Order>> findAll() {

		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); //Retorna uma resposta da requisicao e no corpo a lista 
		

	}
	
	@GetMapping(value = "/{id}") //indica que a requisicao do tipo get aceitara id dentro da url
	public ResponseEntity<Order> findById(@PathVariable Long id) { //@PathVariable indica que o valor sera passado via url
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}

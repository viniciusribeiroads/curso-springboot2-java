package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // Anotacao pra dizer que e um controlador Rest
@RequestMapping(value = "/users") // Indica caminho
public class UserResource {

	// Camada de recursos
	@Autowired // Spring faz a injecao de dependencia
	private UserService service;

	// Retorna um tipo especifico do Spring pra retornar respostas de requisicoes
	// Web
	@GetMapping // anotation que indica que responde requisicao do tipo Get do http
	public ResponseEntity<List<User>> findAll() {

		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //Retorna uma resposta da requisicao e no corpo a lista 
		

	}
	
	@GetMapping(value = "/{id}") //indica que a requisicao do tipo get aceitara id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id) { //@PathVariable indica que o valor sera passado via url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}

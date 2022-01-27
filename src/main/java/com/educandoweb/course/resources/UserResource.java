package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //Anotacao pra dizer que e um controlador Rest
@RequestMapping(value = "/users") //Indica caminho 
public class UserResource {
	
	//Camada de recursos
	
	//Retorna um tipo especifico do Spring pra retornar respostas de requisicoes Web
	@GetMapping //anotation que indica que responde requisicao do tipo Get do http
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "123456");
		return ResponseEntity.ok().body(u);
		
	}
	
	

}

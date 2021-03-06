package io.github.cursodsousa.msclientes.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.cursodsousa.msclientes.dto.ClienteSaveRequest;
import io.github.cursodsousa.msclientes.entities.Cliente;
import io.github.cursodsousa.msclientes.services.ClienteService;
import io.github.cursodsousa.msclientes.services.exceptions.ResourceNotFound;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService service;
	
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody ClienteSaveRequest request) {
		Cliente cliente = request.toModel();
		service.save(cliente);
		URI headerLocation = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.query("cpf={cpf}")
				.buildAndExpand(cliente.getCpf())
				.toUri();
		return ResponseEntity.created(headerLocation).build();
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity<Cliente> dadosClientes(@RequestParam("cpf")String cpf) {
		Cliente cliente = service.getByCpf(cpf)
				.orElseThrow(() -> new ResourceNotFound("Cliente não encontrado, cpf = " + cpf));
		return ResponseEntity.ok(cliente);
	}
}

package io.github.cursodsousa.msavaliadorcredito.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.cursodsousa.msavaliadorcredito.entities.DadosAvaliacao;
import io.github.cursodsousa.msavaliadorcredito.entities.RetornoAvaliacaoCliente;
import io.github.cursodsousa.msavaliadorcredito.entities.SituacaoCliente;
import io.github.cursodsousa.msavaliadorcredito.services.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {
	
	private final AvaliadorCreditoService avaliadorCreditoService;
	
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@GetMapping(value = "/situacao-cliente", params = "cpf")
	public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@RequestParam("cpf") String cpf) {
		SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
		return ResponseEntity.ok(situacaoCliente);
	}
	
	@PostMapping
	public ResponseEntity<RetornoAvaliacaoCliente> realizarAvaliacao(@RequestBody DadosAvaliacao dados) {
		RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService
				.realizarAvaliacao(dados.getCpf(), dados.getRenda());
		return ResponseEntity.ok(retornoAvaliacaoCliente);
		
	}

}

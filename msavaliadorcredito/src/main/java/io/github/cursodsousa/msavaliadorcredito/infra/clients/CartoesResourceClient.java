package io.github.cursodsousa.msavaliadorcredito.infra.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartoesResourceClient {
	
	@GetMapping(params = "cpf")
	ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf);

}

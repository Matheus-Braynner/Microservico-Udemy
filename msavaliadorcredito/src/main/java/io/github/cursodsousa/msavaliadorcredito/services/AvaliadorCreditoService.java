package io.github.cursodsousa.msavaliadorcredito.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import feign.FeignException.FeignClientException;
import io.github.cursodsousa.msavaliadorcredito.entities.SituacaoCliente;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.CartoesPorClienteResponse;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.CartoesResourceClient;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.Cliente;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.ClienteResourceClient;
import io.github.cursodsousa.msavaliadorcredito.services.exceptions.ErroComunicacaoMicroServicesException;
import io.github.cursodsousa.msavaliadorcredito.services.exceptions.ResourceNotFound;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

	private final ClienteResourceClient clientesClient;
	private final CartoesResourceClient cartoesClient;

	public SituacaoCliente obterSituacaoCliente(String cpf) {
		try {
			ResponseEntity<Cliente> dadosClientesResponse = clientesClient.dadosClientes(cpf);
			ResponseEntity<List<CartoesPorClienteResponse>> cartoesResponse = cartoesClient.getCartoesByCliente(cpf);
			return SituacaoCliente.builder().cliente(dadosClientesResponse.getBody()).cartoes(cartoesResponse.getBody())
					.build();
		} catch (FeignClientException e) {
			int status = e.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new ResourceNotFound("Cliente não encontrado, cpf = " + cpf);
			}
			throw new ErroComunicacaoMicroServicesException(e.getMessage(), status);
		}
	}
}
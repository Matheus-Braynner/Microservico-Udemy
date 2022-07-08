package io.github.cursodsousa.msavaliadorcredito.entities;

import java.util.List;

import io.github.cursodsousa.msavaliadorcredito.infra.clients.CartoesPorClienteResponse;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituacaoCliente {
		
	private Cliente cliente;
	private List<CartoesPorClienteResponse> cartoes;
}

package io.github.cursodsousa.mscartoes.dto;

import java.math.BigDecimal;

import io.github.cursodsousa.mscartoes.entities.CartaoCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteResponse {
	private String nome;
	private String bandeira;
	private BigDecimal limiteLiberado;
	
	public static CartoesPorClienteResponse fromModel(CartaoCliente model) {
		return new CartoesPorClienteResponse(
			model.getCartao().getNome(),
			model.getCartao().getBandeira().toString(),
			model.getLimite());
	}
}

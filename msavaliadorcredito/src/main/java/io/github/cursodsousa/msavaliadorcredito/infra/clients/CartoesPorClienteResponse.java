package io.github.cursodsousa.msavaliadorcredito.infra.clients;

import java.math.BigDecimal;

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

}

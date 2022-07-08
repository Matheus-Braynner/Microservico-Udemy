package io.github.cursodsousa.msavaliadorcredito.infra.clients;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cartao {

		private Long id;
		private String nome;
		private BandeiraCartao bandeira;
		private BigDecimal limiteBasico;
		
}

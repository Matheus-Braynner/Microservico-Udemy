package io.github.cursodsousa.msavaliadorcredito.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartaoAprovado {
	private String cartao;
	private String bandeira;
	private BigDecimal limiteAprovado;

}

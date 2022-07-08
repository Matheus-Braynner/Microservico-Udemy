package io.github.cursodsousa.msavaliadorcredito.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetornoAvaliacaoCliente {
	private List<CartaoAprovado> cartoes = new ArrayList<>();

}

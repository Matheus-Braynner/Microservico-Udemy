package io.github.cursodsousa.msavaliadorcredito.infra.clients;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;	
	private Integer idade;

}

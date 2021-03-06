package io.github.cursodsousa.msclientes.dto;

import io.github.cursodsousa.msclientes.entities.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteSaveRequest {
	
	private String cpf;
	private String nome;
	private Integer idade;
	
	public Cliente toModel() {
		return new Cliente(cpf, nome, idade);
	}
}

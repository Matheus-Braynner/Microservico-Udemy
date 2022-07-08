package io.github.cursodsousa.mscartoes.dto;

import java.math.BigDecimal;

import io.github.cursodsousa.mscartoes.entities.Cartao;
import io.github.cursodsousa.mscartoes.entities.enums.BandeiraCartao;
import lombok.Data;

@Data
public class CartaoSaveRequest {
	
	private String nome;
	private BandeiraCartao bandeira;
	private BigDecimal renda;
	private BigDecimal limite;
	
	public Cartao toModel() {
		return new Cartao(nome, bandeira, renda, limite);
	}
}

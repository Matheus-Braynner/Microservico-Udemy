package io.github.cursodsousa.msavaliadorcredito.services.exceptions;

import lombok.Getter;

public class ErroComunicacaoMicroServicesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	@Getter
	private Integer status;
	
	public ErroComunicacaoMicroServicesException(String msg, Integer status) {
		super(msg);
		this.status = status;
	}

}

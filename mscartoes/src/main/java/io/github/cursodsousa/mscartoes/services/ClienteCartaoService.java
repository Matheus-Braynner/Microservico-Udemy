package io.github.cursodsousa.mscartoes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.cursodsousa.mscartoes.entities.CartaoCliente;
import io.github.cursodsousa.mscartoes.repositories.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
	
	private final ClienteCartaoRepository repository;
	
	public List<CartaoCliente> listCartoesByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
}

package io.github.cursodsousa.mscartoes.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.cursodsousa.mscartoes.entities.CartaoCliente;

@Repository
public interface ClienteCartaoRepository extends JpaRepository<CartaoCliente, Long> {
	
	List<CartaoCliente> findByCpf(String cpf);

}

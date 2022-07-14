package br.com.alura.comex.infra.cliente;

import br.com.alura.comex.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

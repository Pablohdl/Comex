package br.com.alura.comex.infra.cliente;

import br.com.alura.comex.domain.cliente.Cliente;
import org.springframework.data.domain.Page;

public class ClienteDetalheDto {

    private String nome;
    private String cpf;
    private String telefone;
    private String local;

    public ClienteDetalheDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.local = cliente.getCidade() + "/" + cliente.getEstado();
    }

    public static Page<ClienteDetalheDto> converterPagina(Page<Cliente> clientes) {
        return clientes.map(ClienteDetalheDto::new);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLocal() {
        return local;
    }

    public static Page<ClienteDetalheDto> converter(Page<Cliente> clientes) {
        return clientes.map(ClienteDetalheDto::new);
    }
}

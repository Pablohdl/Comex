package br.com.alura.comex.model.builder;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Pedido;

import java.util.List;

public class ClienteBuilder {

    private String nome;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    private List<Pedido> listaDePedidos;

    public ClienteBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder comTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public ClienteBuilder comRua(String rua) {
        this.rua = rua;
        return this;
    }
    public ClienteBuilder comNumero(String numero) {
        this.numero = numero;
        return this;
    }
    public ClienteBuilder comComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }
    public ClienteBuilder comBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }
    public ClienteBuilder comCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }
    public ClienteBuilder comEstado(String estado) {
        this.estado = estado;
        return this;
    }


    public ClienteBuilder comListaDePedidos(List<Pedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
        return this;
    }

    public Cliente build() {
        return new Cliente(nome, cpf, telefone, rua,numero,complemento,bairro,cidade,estado, listaDePedidos);
    }
}

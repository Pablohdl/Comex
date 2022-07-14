package br.com.alura.comex.infra.cliente;

import br.com.alura.comex.domain.cliente.Cliente;
import br.com.alura.comex.infra.cliente.ClienteRepository;

public class AtualizacaoClienteForm {


    private String nome;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente atualizar(Long id, ClienteRepository clienteRepository) {

        Cliente cliente =  clienteRepository.getOne(id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setBairro(this.bairro);
        cliente.setCidade(this.cidade);
        cliente.setNumero(this.numero);
        cliente.setTelefone(this.telefone);
        cliente.setComplemento(this.complemento);
        cliente.setRua(this.rua);
        cliente.setEstado(this.estado);

        return cliente;
    }
}

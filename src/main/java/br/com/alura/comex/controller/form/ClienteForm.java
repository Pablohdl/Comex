package br.com.alura.comex.controller.form;

import br.com.alura.comex.model.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteForm {


    @NotNull
    @Size(min = 2)
    private String nome;
    @NotNull
    @Length(min = 11,max = 11)
    @NotEmpty
    private String cpf;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    private String rua;
    @NotNull
    @NotEmpty
    private String numero;
    private String complemento;
    @NotNull
    @NotEmpty
    private String bairro;
    @NotNull
    @NotEmpty
    private String cidade;
    @NotNull
    @NotEmpty
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

    public Cliente converter() {

       return new Cliente(nome,cpf,telefone,rua,numero,complemento,bairro,cidade,estado);
    }
}

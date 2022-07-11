package br.com.alura.comex.infra.cliente;

import br.com.alura.comex.infra.pedido.Pedido;
import br.com.alura.comex.infra.usuario.Usuario;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String telefone;
    @NotNull
    private String rua;
    @NotNull
    private String numero;
    @NotNull
    private String complemento;
    @NotNull
    private String bairro;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> listaDePedidos;
    @OneToOne(optional = false, mappedBy = "cliente")
    private Usuario usuario;

    @Deprecated
    protected Cliente() {

    }

    public Cliente(String nome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado,List<Pedido> listaDePedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.listaDePedidos = listaDePedidos;
    }
    public Cliente(String nome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void setListaDePedidos(List<Pedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", Telefone='" + telefone + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

package br.com.alura.comex.domain.categoria;

import br.com.alura.comex.domain.enun.StatusCategoria;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusCategoria status  = StatusCategoria.ATIVA;



    public Categoria() {

    }

    private Categoria(Long id, String nome, StatusCategoria status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Categoria(String nome, StatusCategoria status) {
        this.nome = nome;
        this.status = status;
    }
    public Categoria(String nome) {
        this.nome = nome;
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

    public StatusCategoria getStatus() {
        return status;
    }

    public void setStatus(StatusCategoria status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }
}
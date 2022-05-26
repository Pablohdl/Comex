package br.com.alura.comex;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;

public class Pedido {

	@CsvBindByName(column = "categoria", required = true)
    private String categoria;
    @CsvBindByName(column = "produto", required = true)
    private String produto;
    @CsvBindByName(column = "preco", required = true)
    private BigDecimal preco;
    @CsvBindByName(column = "quantidade", required = true)
    private int quantidade;
    @CsvBindByName(column = "data", required = true)
    private String data;
    @CsvBindByName(column = "cliente", required = true)
    private String cliente;


    public String getCategoria() {
        return categoria;
    }

    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "categoria='" + categoria + '\'' +
                ", produto='" + produto + '\'' +
                ", cliente='" + cliente + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }
     public BigDecimal getValorTotal() {
    	return getPreco().multiply(new BigDecimal(getQuantidade()));    	 
    	 	
    }

}

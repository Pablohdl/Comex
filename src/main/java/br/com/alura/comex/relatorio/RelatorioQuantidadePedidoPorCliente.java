package br.com.alura.comex.relatorio;

public class RelatorioQuantidadePedidoPorCliente {

    private String nomeCliente;
    private int quantidadePedidos;


    public RelatorioQuantidadePedidoPorCliente() {
    }

    public RelatorioQuantidadePedidoPorCliente(String nomeCliente, int quantidadePedidos) {
        this.nomeCliente = nomeCliente;
        this.quantidadePedidos = quantidadePedidos;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadePedidos() {
        return quantidadePedidos;
    }

    public void setQuantidadePedidos(int quantidadePedidos) {
        this.quantidadePedidos = quantidadePedidos;
    }
}

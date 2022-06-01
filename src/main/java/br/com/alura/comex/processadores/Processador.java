package br.com.alura.comex.processadores;

import br.com.alura.comex.model.Pedido;

import java.io.IOException;
import java.util.List;

public interface Processador {
	
	List<Pedido> getPedidos(String caminhoArquivo) throws IOException;

}

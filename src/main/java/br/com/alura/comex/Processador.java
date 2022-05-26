package br.com.alura.comex;

import java.io.IOException;
import java.util.List;

public interface Processador {
	
	List<Pedido> getPedidos(String caminho_arquivo) throws IOException;

}

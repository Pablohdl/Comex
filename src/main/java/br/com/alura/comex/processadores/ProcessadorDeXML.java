package br.com.alura.comex.processadores;

import br.com.alura.comex.model.Pedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProcessadorDeXML implements Processador{
		@Override
    	public List<Pedido> getPedidos(String caminhoArquivo) throws IOException {
        return new XmlMapper().readValue(new File(caminhoArquivo), new TypeReference<>() {});
    	}
}

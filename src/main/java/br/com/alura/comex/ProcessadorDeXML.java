package br.com.alura.comex;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ProcessadorDeXML implements Processador{
		@Override
    	public List<Pedido> getPedidos(String caminho_arquivo) throws IOException {
        return new XmlMapper().readValue(new File(caminho_arquivo), new TypeReference<>() {});
    	}
}

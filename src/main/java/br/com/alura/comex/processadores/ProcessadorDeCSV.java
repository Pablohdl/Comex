package br.com.alura.comex.processadores;

import br.com.alura.comex.model.Pedido;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProcessadorDeCSV implements Processador {
    @Override
    public List<Pedido> getPedidos(String caminhoArquivo) throws FileNotFoundException {

        return new CsvToBeanBuilder<Pedido>(new FileReader(caminhoArquivo))
                .withType(Pedido.class)
                .withSeparator(',')
                .build()
                .parse();
    }
}
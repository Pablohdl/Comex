package br.com.alura.comex.infra.cliente;

import br.com.alura.comex.infra.cliente.AtualizacaoClienteForm;
import br.com.alura.comex.domain.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @PostMapping
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.converter();
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));

    }


    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm form) {
        Cliente cliente = form.atualizar(id,clienteRepository);


        return ResponseEntity.ok(new ClienteDto(cliente));


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

   @GetMapping
    public ResponseEntity<Page<ClienteDetalheDto>> listarTodos(@RequestParam(defaultValue = "0")int pagina) {
        Pageable pageable = PageRequest.of(pagina, 5, Sort.by(Sort.Direction.ASC, "nome"));
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        Page<ClienteDetalheDto> clienteDetalheDto = ClienteDetalheDto.converterPagina(clientes);
        return ResponseEntity.ok().body(clienteDetalheDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> encontrarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent())
            return ResponseEntity.ok(new ClienteDto(cliente.get()));
        return ResponseEntity.notFound().build();
    }

}

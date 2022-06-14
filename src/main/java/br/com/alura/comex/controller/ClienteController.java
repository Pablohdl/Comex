package br.com.alura.comex.controller;

import br.com.alura.comex.controller.dto.CategoriaDto;
import br.com.alura.comex.controller.dto.ClienteDto;
import br.com.alura.comex.controller.dto.ProdutoDto;
import br.com.alura.comex.controller.form.AtualizacaoClienteForm;
import br.com.alura.comex.controller.form.AtualizacaoProdutoForm;
import br.com.alura.comex.controller.form.CategoriaForm;
import br.com.alura.comex.controller.form.ClienteForm;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDto> lista(Long id) {
        if(id == null) {
            List<Cliente> clientes = clienteRepository.findAll();
            return ClienteDto.converter(clientes);
        } else {
            Optional<Cliente> clientes = clienteRepository.findById(id);
            return ClienteDto.converterOp(clientes);
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.converter();
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm form) {
        Cliente cliente = form.atualizar(id,clienteRepository);


        return ResponseEntity.ok(new ClienteDto(cliente));


    }




}

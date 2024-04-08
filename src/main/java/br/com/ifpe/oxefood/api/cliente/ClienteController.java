package br.com.ifpe.oxefood.api.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Serviço responsável por salvar um cliente no sistema.", description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema.")
    @PostMapping // cadastrar dados para api pelo corpo do jason
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

        Cliente cliente = clienteService.save(request.build());
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @Operation(summary = "Serviço responsável por listar os clientes no sistema.", description = "Exemplo de descrição de um endpoint responsável por listar os cliente no sistema.")
    @GetMapping // passar todos os dados para api - listar clientes
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Serviço responsável por listar um cliente pelo id no sistema.", description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema.")
    @GetMapping("/{id}") // passar dados para api por id - listar por id
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @Operation(summary = "Serviço responsável por alterar um cliente pelo id no sistema.", description = "Exemplo de descrição de um endpoint responsável por alterar um cliente no sistema.")
    @PutMapping("/{id}") // alterar registro do cliente por id
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço responsável por deletar um cliente pelo id no sistema.", description = "Exemplo de descrição de um endpoint responsável por deletar um cliente no sistema.")
    @DeleteMapping("/{id}")// deletar registro por id
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}

package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin

public class EntregadorController {
    @Autowired
    private EntregadorService entregadorService;

    @Operation(
       summary = "Serviço responsável por salvar um entregador no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um entregador no sistema.")
    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {

        Entregador entregador = entregadorService.save(request.build());
        return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
    }

    @Operation(
       summary = "Serviço responsável por listar os entregadores no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por listar os entregadores no sistema.")
     
    @GetMapping// passar todos os dados para api - listar entregador
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }

    @Operation(
       summary = "Serviço responsável por listar um entregador no sistema pelo id.",
       description = "Exemplo de descrição de um endpoint responsável por listar um entregador no sistema pelo id.")
    @GetMapping("/{id}")// passar dados para api por id - listar por id
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }

    @Operation(
       summary = "Serviço responsável por alterar um entregador no sistema pelo id.",
       description = "Exemplo de descrição de um endpoint responsável por alterar um entregador no sistema pelo id.")
    @PutMapping("/{id}")// alterar registro do cliente por id
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

        entregadorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(
       summary = "Serviço responsável por deletar um entregador no sistema pelo id.",
       description = "Exemplo de descrição de um endpoint responsável por deletar um entregador no sistema pelo id.")
  @DeleteMapping("/{id}")//deletar registro por id
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       entregadorService.delete(id);
       return ResponseEntity.ok().build();
   }

}

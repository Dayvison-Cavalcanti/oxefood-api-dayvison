package br.com.ifpe.oxefood.modelo.produto;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
        @Autowired
   private ProdutoRepository repository;

   @Transactional
   public Produto save(Produto produto) {

       produto.setHabilitado(Boolean.TRUE);
       produto.setVersao(1L);
       produto.setDataCriacao(LocalDate.now());
       return repository.save(produto);
   }
}

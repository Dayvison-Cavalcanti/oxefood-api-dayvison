package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // equivale ao getter e setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EntregadorRequest {

    private String nome;

    private String cpf;

    private String rg;

   @JsonFormat(pattern = "dd/MM/yyyy") // armazenar só uma data (localdate) utilizar @JsonFormat(pattern = "dd/MM/yyyy"); armazenar hora e data (LocalDateTime) utilizar @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dataNascimento;

    private String foneCelular;

    private String foneFixo;

    private Integer qtdEntregasRealizadas;

    private Double valorFrete;

    private String enderecoRua;

    private String enderecoNumero;

    private String enderecoBairro;

    private String enderecoCidade;

    private String enderecoCep;

    private String enderecoUf;

    private String enderecoComplemento;

    private Boolean ativo;

    public Entregador build() {

        return Entregador.builder()
             
                 .nome(nome)
                 .cpf(cpf)         
                 .rg(rg)         
                 .dataNascimento(dataNascimento)         
                 .foneCelular(foneCelular)         
                 .foneFixo(foneFixo)         
                 .qtdEntregasRealizadas(qtdEntregasRealizadas)         
                 .valorFrete(valorFrete)            
                 .enderecoRua(enderecoRua)           
                 .enderecoNumero(enderecoNumero)           
                 .enderecoBairro(enderecoBairro)            
                 .enderecoCidade(enderecoCidade)           
                 .enderecoCep(enderecoCep)            
                 .enderecoUf(enderecoUf)
                 .enderecoComplemento(enderecoComplemento)
                 .ativo(ativo)
                .build();
    }
}

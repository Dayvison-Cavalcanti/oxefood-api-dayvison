package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // equivale ao getter e setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClienteRequest {
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy") // armazenar só uma data (localdate) utilizar @JsonFormat(pattern = "dd/MM/yyyy"); armazenar hora e data (LocalDateTime) utilizar @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dataNascimento;

    private String cpf;

    private String foneCelular;

    private String foneFixo;

    public Cliente build() {

        return Cliente.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .build();
    }

}

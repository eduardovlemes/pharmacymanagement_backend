package br.com.project.PharmacyManagement.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    @NotBlank(message = "O CEP não deve estar em branco.")
    private String cep;

    @NotBlank(message = "A RUA não deve estar em branco.")
    private String logradouro;

    @NotNull(message = "O NÚMERO não deve estar em branco.")
    private Integer number;

    @NotBlank(message = "O BAIRRO não deve estar em branco.")
    private String bairro;

    @NotBlank(message = "A CIDADE não deve estar em branco.")
    private String localidade;

    @NotBlank(message = "O ESTADO não deve estar em branco.")
    private String uf;

    private String addressCompl;

    @NotNull(message = "A LATITUDE não deve estar em branco.")
    private BigDecimal latitude;

    @NotNull(message = "A LONGITUDE não deve estar em branco.")
    private BigDecimal longitude;

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", number=" + number +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", addressCompl='" + addressCompl + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

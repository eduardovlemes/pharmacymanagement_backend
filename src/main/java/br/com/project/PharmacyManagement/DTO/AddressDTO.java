package br.com.project.PharmacyManagement.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    @NotNull(message = "O CEP do endereço é obrigatório.")
    private String postalcode;

    @NotNull(message = "A rua do endereço é obrigatório.")
    private String street;

    @NotNull(message = "O número do endereço é obrigatório.")
    private Integer number;

    @NotNull(message = "O bairro do endereço é obrigatório.")
    private String district;

    @NotNull(message = "A cidade do endereço é obrigatório.")
    private String city;

    @NotNull(message = "O estado do endereço é obrigatório.")
    private String state;

    private String addressCompl;

    @NotNull(message = "A latitude do endereço é obrigatório.")
    private BigDecimal latitude;

    @NotNull(message = "A longitude do endereço é obrigatório.")
    private BigDecimal longitude;

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", postalcode='" + postalcode + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", addressCompl='" + addressCompl + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

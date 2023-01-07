package br.com.project.PharmacyManagement.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PharmacyDTO {
    private Long id;
    @NotNull(message = "A razão social da farmácia é obrigatório.")
    private String corporateName;
    @NotNull(message = "O CNPJ da farmácia é obrigatório.")
    private String cnpj;
    @NotNull(message = "O nome fantasia da farmácia é obrigatório.")
    private String tradeName;
    @NotNull(message = "O email da farmácia é obrigatório.")
    private String email;

    private String phone;
    @NotNull(message = "O celular da farmácia é obrigatório.")
    private String cellphone;

    private Long id_address;

    private AddressDTO addressDTO;

    @Override
    public String toString() {
        return "PharmacyDTO{" +
                "id=" + id +
                ", corporateName='" + corporateName + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", tradeName='" + tradeName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", idAddress=" + id_address +
                ", addressDTO=" + addressDTO +
                '}';
    }
}

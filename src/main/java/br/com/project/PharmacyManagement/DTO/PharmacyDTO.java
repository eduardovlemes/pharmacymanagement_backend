package br.com.project.PharmacyManagement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PharmacyDTO {
    private Long id;

    @NotBlank(message = "A RAZÃO SOCIAL não deve estar em branco.")
    private String corporateName;

    @NotBlank(message = "O CNPJ não deve estar em branco.")
    private String cnpj;

    @NotBlank(message = "O NOME FANTASIA não deve estar em branco.")
    private String tradeName;

    @NotBlank(message = "O EMAIL não deve estar em branco.")
    @Email(message = "EMAIL inválido.")
    private String email;

    private String phone;

    @NotBlank(message = "O CELULAR não deve estar em branco.")
    private String cellphone;

    private AddressDTO address;

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
                ", address=" + address +
                '}';
    }
}

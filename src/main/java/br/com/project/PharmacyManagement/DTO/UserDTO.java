package br.com.project.PharmacyManagement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotBlank(message = "O EMAIL não deve estar em branco.")
    @Email(message = "Email inválido.")
    private String email;

    @NotBlank(message = "O SENHA não deve estar em branco.")
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

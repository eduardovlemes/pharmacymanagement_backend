package br.com.project.PharmacyManagement.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotNull(message = "O email do usuário é obrigatório.")
    private String email;

    @NotNull(message = "A senha do usuário é obrigatória.")
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

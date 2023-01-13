package br.com.project.PharmacyManagement.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DrugDTO {

    private Long id;

    @NotBlank(message = "O NOME do medicamento não deve estar em branco.")
    private String drugName;

    @NotBlank(message = "O LABORATÓRIO não deve estar em branco.")
    private String lab;

    @NotBlank(message = "A DOSAGEM não deve estar em branco.")
    private String dosage;

    private String description;

    @NotNull(message = "O PREÇO não deve estar em branco.")
    private BigDecimal price;

    @NotBlank(message = "O TIPO não deve estar em branco.")
    private String type;

    @Override
    public String toString() {
        return "DrugDTO{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", lab='" + lab + '\'' +
                ", dosage='" + dosage + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}

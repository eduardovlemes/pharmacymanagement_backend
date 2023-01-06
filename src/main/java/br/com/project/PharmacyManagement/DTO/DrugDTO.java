package br.com.project.PharmacyManagement.DTO;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DrugDTO {

    private Long id;

    @NotNull(message = "O nome do medicamento é obrigatório.")
    private String drugName;
    @NotNull(message = "O nome do laboratório do medicamento é obrigatório.")
    private String lab;
    @NotNull(message = "A dosagem do medicamento é obrigatória.")
    private String dosage;

    private String description;
    @NotNull(message = "O preço do medicamento é obrigatório.")
    private BigDecimal price;
    @NotNull(message = "O tipo do medicamento é obrigatório.")
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

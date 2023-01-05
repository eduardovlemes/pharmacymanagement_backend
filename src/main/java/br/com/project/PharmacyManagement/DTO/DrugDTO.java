package br.com.project.PharmacyManagement.DTO;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DrugDTO {

    private Long id;

    private String drugName;

    private String lab;

    private String dosage;

    private String description;

    private BigDecimal price;

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

package br.com.project.PharmacyManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "drug")
@Getter
@Setter
public class DrugEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "drug_name", nullable = false, length = 150)
    private String drugName;
    @Column(name = "lab", nullable = false, length = 150)
    private String lab;
    @Column(name = "dosage", nullable = false, length = 4)
    private String dosage;
    @Column(name = "description")
    private String description;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "type", nullable = false, length = 100)
    private String type;
}

package br.com.project.PharmacyManagement.model;

import br.com.project.PharmacyManagement.DTO.PharmacyDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pharmacy")
@Getter
@Setter
public class PharmacyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "corporate_name", nullable = false)
    private String corporateName;
    @Column(name = "cnpj", nullable = false,length = 14)
    private String cnpj;
    @Column(name = "trade_name", nullable = false)
    private String tradeName;
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @Column(name = "phone", length = 10)
    private String phone;
    @Column(name = "cellphone", nullable = false, length = 11)
    private String cellphone;

    @OneToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private AddressEntity addressEntity;

    public PharmacyEntity(PharmacyDTO pharmacyDTO, AddressEntity addressEntity) {
    }
}

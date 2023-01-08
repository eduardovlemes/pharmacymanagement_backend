package br.com.project.PharmacyManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pharmacy")
@Getter
@Setter
public class PharmacyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmacy_id_seq")
    @SequenceGenerator(name = "pharmacy_id_seq", sequenceName = "pharmacy_id_seq", allocationSize = 1)
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}

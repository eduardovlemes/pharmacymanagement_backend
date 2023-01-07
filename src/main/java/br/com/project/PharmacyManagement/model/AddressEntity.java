package br.com.project.PharmacyManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "postalcode", nullable = false, length = 8)
    private String postalcode;

    @Column(name = "street", nullable = false, length = 200)
    private String street;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "district", nullable = false, length = 100)
    private String district;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @Column(name = "address_compl", length = 150)
    private String addressCompl;

    @Column(name = "latitude", nullable = false, precision = 8, scale = 6)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false, precision = 9, scale = 6)
    private BigDecimal longitude;

    @OneToOne
    @JoinColumn(name = "id_pharmacy", referencedColumnName = "id")
    private PharmacyEntity pharmacy;

//    public AddressEntity(String postalcode, String street, Integer number, String district, String city, String state, String addressCompl, BigDecimal latitude, BigDecimal longitude) {
//    this.postalcode = postalcode;
//    this.street = street;
//    this.number = number;
//    this.district = district;
//    this.city = city;
//    this.state = state;
//    this.addressCompl = addressCompl;
//    this.latitude = latitude;
//    this.longitude = longitude;
//    }
}

package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.DTO.AddressDTO;
import br.com.project.PharmacyManagement.DTO.PharmacyDTO;
import br.com.project.PharmacyManagement.model.AddressEntity;
import br.com.project.PharmacyManagement.model.PharmacyEntity;
import br.com.project.PharmacyManagement.repository.AddressEntityRepository;
import br.com.project.PharmacyManagement.repository.PharmacyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyEntityService {

    @Autowired
    private PharmacyEntityRepository pharmacyEntityRepository;

    @Autowired
    private AddressEntityRepository addressEntityRepository;

    public PharmacyEntity savePharmacy(PharmacyEntity pharmacy){
        return pharmacyEntityRepository.save(pharmacy);
    }

    public PharmacyEntity fromDTO(PharmacyDTO pharmacyDTO){
        PharmacyEntity pharmacy = new PharmacyEntity();
        pharmacy.setId(pharmacyDTO.getId());
        pharmacy.setCorporateName(pharmacyDTO.getCorporateName());
        pharmacy.setCnpj(pharmacyDTO.getCnpj());
        pharmacy.setTradeName(pharmacyDTO.getTradeName());
        pharmacy.setEmail(pharmacyDTO.getEmail());
        pharmacy.setPhone(pharmacyDTO.getPhone());
        pharmacy.setCellphone(pharmacyDTO.getCellphone());

        AddressDTO addressDTO = pharmacyDTO.getAddress();

        if(addressDTO != null){
            AddressEntity address = new AddressEntity();
            address.setId(addressDTO.getId());
            address.setPostalcode(addressDTO.getPostalcode());
            address.setStreet(addressDTO.getStreet());
            address.setNumber(addressDTO.getNumber());
            address.setDistrict(addressDTO.getDistrict());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setAddressCompl(addressDTO.getAddressCompl());
            address.setLatitude(addressDTO.getLatitude());
            address.setLongitude(addressDTO.getLongitude());

            pharmacy.setAddress(address);
        }
        return pharmacy;
    }
}

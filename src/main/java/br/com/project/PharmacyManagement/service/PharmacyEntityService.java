package br.com.project.PharmacyManagement.service;

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


    public PharmacyEntity savePharmacy(PharmacyDTO pharmacyDTO){
        AddressEntity addressEntity = new AddressEntity(
                pharmacyDTO.getAddressDTO().getPostalcode(),
                pharmacyDTO.getAddressDTO().getStreet(),
                pharmacyDTO.getAddressDTO().getNumber(),
                pharmacyDTO.getAddressDTO().getDistrict(),
                pharmacyDTO.getAddressDTO().getCity(),
                pharmacyDTO.getAddressDTO().getState(),
                pharmacyDTO.getAddressDTO().getAddressCompl(),
                pharmacyDTO.getAddressDTO().getLatitude(),
                pharmacyDTO.getAddressDTO().getLongitude()
        );
        addressEntity = addressEntityRepository.save(addressEntity);
        PharmacyEntity pharmacyEntity = new PharmacyEntity(pharmacyDTO, addressEntity);

        return  pharmacyEntityRepository.save(pharmacyEntity);
    }

//    private PharmacyEntity convertDTO(PharmacyDTO pharmacyDTO){
//        PharmacyEntity pharmacy = new PharmacyEntity();
//        pharmacy.setCorporateName(pharmacyDTO.getCorporateName());
//        pharmacy.setCnpj(pharmacyDTO.getCnpj());
//        pharmacy.setTradeName(pharmacyDTO.getTradeName());
//        pharmacy.setEmail(pharmacyDTO.getEmail());
//        pharmacy.setPhone(pharmacyDTO.getPhone());
//        pharmacy.setCellphone(pharmacyDTO.getCellphone());
//
//        return pharmacy;
//    }
}

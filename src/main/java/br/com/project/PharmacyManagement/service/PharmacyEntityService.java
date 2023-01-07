package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.DTO.PharmacyDTO;
import br.com.project.PharmacyManagement.model.AddressEntity;
import br.com.project.PharmacyManagement.model.PharmacyEntity;
import br.com.project.PharmacyManagement.repository.AddressEntityRepository;
import br.com.project.PharmacyManagement.repository.PharmacyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyEntityService {

    @Autowired
    private PharmacyEntityRepository pharmacyEntityRepository;

    @Autowired
    private AddressEntityRepository addressEntityRepository;

    public PharmacyEntity savePharmacy(PharmacyEntity pharmacy){
        return pharmacyEntityRepository.save(pharmacy);
    }

    public void savePharmacyAndAddress(PharmacyDTO pharmacyDTO){
        AddressEntity address = new AddressEntity();
        address.setId(pharmacyDTO.getAddress().getId());
        address.setPostalcode(pharmacyDTO.getAddress().getPostalcode());
        address.setStreet(pharmacyDTO.getAddress().getStreet());
        address.setNumber(pharmacyDTO.getAddress().getNumber());
        address.setDistrict(pharmacyDTO.getAddress().getDistrict());
        address.setCity(pharmacyDTO.getAddress().getCity());
        address.setState(pharmacyDTO.getAddress().getState());
        address.setAddressCompl(pharmacyDTO.getAddress().getAddressCompl());
        address.setLatitude(pharmacyDTO.getAddress().getLatitude());
        address.setLongitude(pharmacyDTO.getAddress().getLongitude());

        addressEntityRepository.save(address);

        PharmacyEntity pharmacy = new PharmacyEntity();
        pharmacy.setCorporateName(pharmacyDTO.getCorporateName());
        pharmacy.setCnpj(pharmacyDTO.getCnpj());
        pharmacy.setTradeName(pharmacyDTO.getTradeName());
        pharmacy.setEmail(pharmacyDTO.getEmail());
        pharmacy.setPhone(pharmacyDTO.getPhone());
        pharmacy.setCellphone(pharmacyDTO.getCellphone());
        pharmacy.setAddress(address);

        pharmacyEntityRepository.save(pharmacy);
    }

    public List<PharmacyEntity> findAllPharmacies(){
        return pharmacyEntityRepository.findAll();
    }

}

package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.repository.AddressEntityRepository;
import br.com.project.PharmacyManagement.repository.PharmacyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressEntityService {

    @Autowired
    private AddressEntityRepository addressEntityRepository;

    @Autowired
    private PharmacyEntityRepository pharmacyEntityRepository;

//    public AddressEntity saveAddress(AddressEntity addressEntity){
//        return addressEntityRepository.save(addressEntity);

//        AddressEntity address = convertDTO(addressDTO);
//        address = addressEntityRepository.save(address);
//        return address.getId();
//}
//    private AddressEntity convertDTO(AddressDTO addressDTO){
//        AddressEntity address = new AddressEntity();
//        address.setPostalcode(addressDTO.getPostalcode());
//        address.setStreet(addressDTO.getStreet());
//        address.setNumber(addressDTO.getNumber());
//        address.setDistrict(addressDTO.getDistrict());
//        address.setCity(addressDTO.getCity());
//        address.setState(addressDTO.getState());
//        address.setAddressCompl(addressDTO.getAddressCompl());
//        address.setLatitude(addressDTO.getLatitude());
//        address.setLongitude(addressDTO.getLongitude());
//        return address;}
//
}

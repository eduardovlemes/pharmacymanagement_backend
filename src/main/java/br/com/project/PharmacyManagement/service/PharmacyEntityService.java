package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.DTO.PharmacyDTO;
import br.com.project.PharmacyManagement.model.AddressEntity;
import br.com.project.PharmacyManagement.model.PharmacyEntity;
import br.com.project.PharmacyManagement.repository.AddressEntityRepository;
import br.com.project.PharmacyManagement.repository.PharmacyEntityRepository;
import br.com.project.PharmacyManagement.service.exception.BadRequestException;
import br.com.project.PharmacyManagement.service.exception.NotFoundException;
import br.com.project.PharmacyManagement.service.exception.ServerSideException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PharmacyEntityService {

    @Autowired
    private PharmacyEntityRepository pharmacyEntityRepository;

    @Autowired
    private AddressEntityRepository addressEntityRepository;


    public PharmacyEntity savePharmacyAndAddress(PharmacyDTO pharmacyDTO){

        try {
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

            return pharmacyEntityRepository.save(pharmacy);

        }catch (Exception e){
            throw new ServerSideException("Erro ao salvar a farmácia e seu endereço. Mensagem localizada: " + e.getLocalizedMessage());
        }
    }


    public List<PharmacyEntity> findAllPharmacies(){

        try {
            return pharmacyEntityRepository.findAll().stream().peek(pharmacyEntity -> pharmacyEntity.getAddress().getId()).collect(Collectors.toList());

        } catch (Exception e){
            throw new NotFoundException("As farmácias cadastradas não foram encontradas. Mensagem localizada:" + e.getLocalizedMessage());
        }
    }


    public Optional<PharmacyEntity> findPharmacyById(Long id) {

        try {
            return Optional.ofNullable(pharmacyEntityRepository.findById(id).orElseThrow(() ->
                    new NotFoundException("O id da farmácia não foi encontrado no banco de dados. Verifique se está correto.")));

        }catch (Exception e){
            throw new BadRequestException("A farmácia solicitada não foi encontrada. Mensagem localizada:" + e.getLocalizedMessage());
        }
    }


    public PharmacyEntity updatePharmacyById(Long id, PharmacyDTO pharmacyDTO){

        try {
            PharmacyEntity pharmacy = pharmacyEntityRepository.findById(id).orElseThrow(()->
                    new NotFoundException("O id da farmácia não foi encontrado no banco de dados."));

            AddressEntity address = pharmacy.getAddress();
            address.setPostalcode(pharmacyDTO.getAddress().getPostalcode());
            address.setStreet(pharmacyDTO.getAddress().getStreet());
            address.setNumber(pharmacyDTO.getAddress().getNumber());
            address.setDistrict(pharmacyDTO.getAddress().getDistrict());
            address.setCity(pharmacyDTO.getAddress().getCity());
            address.setState(pharmacyDTO.getAddress().getState());
            address.setAddressCompl(pharmacyDTO.getAddress().getAddressCompl());
            address.setLatitude(pharmacyDTO.getAddress().getLatitude());
            address.setLongitude(pharmacyDTO.getAddress().getLongitude());

            pharmacy.setCorporateName(pharmacyDTO.getCorporateName());
            pharmacy.setCnpj(pharmacyDTO.getCnpj());
            pharmacy.setTradeName(pharmacyDTO.getTradeName());
            pharmacy.setEmail(pharmacyDTO.getEmail());
            pharmacy.setPhone(pharmacyDTO.getPhone());
            pharmacy.setCellphone(pharmacyDTO.getCellphone());

            return pharmacyEntityRepository.save(pharmacy);

        }catch (Exception e){
            throw new ServerSideException("Erro ao atualizar a farmácia. Mensagem localizada: " + e.getLocalizedMessage());
        }
    }


    public PharmacyEntity deletePharmacyById(Long id){

        try {
            pharmacyEntityRepository.deleteById(id);
            return null;

        } catch (Exception e){
            throw new BadRequestException("A farmácia solicitada não foi encontrada. Mensagem localizada:" + e.getLocalizedMessage());
        }
    }
}

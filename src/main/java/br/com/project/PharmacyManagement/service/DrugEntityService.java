package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.DTO.DrugDTO;
import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.repository.DrugEntityRepository;
import br.com.project.PharmacyManagement.service.exception.BadRequestException;
import br.com.project.PharmacyManagement.service.exception.NotFoundException;
import br.com.project.PharmacyManagement.service.exception.ServerSideException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugEntityService {

    @Autowired
    private DrugEntityRepository drugEntityRepository;


    public DrugEntity saveDrug(DrugDTO drugDTO){

        try {
            DrugEntity drug = new DrugEntity();
            drug.setDrugName(drugDTO.getDrugName());
            drug.setLab(drugDTO.getLab());
            drug.setDosage(drugDTO.getDosage());
            drug.setDescription(drugDTO.getDescription());
            drug.setPrice(drugDTO.getPrice());
            drug.setType(drugDTO.getType());

            return drugEntityRepository.save(drug);

        }catch (Exception e){
            throw new ServerSideException("Erro ao salvar o medicamento. Mensagem localizada: " + e.getLocalizedMessage());
        }
    }


    public List<DrugEntity> findAllDrugs(){

        try {
            return (List<DrugEntity>) drugEntityRepository.findAll();

        }catch (Exception e){
            throw new NotFoundException("Os medicamentos cadastrados não foram encontrados. Mensagem localizada:" + e.getLocalizedMessage());
        }
    }

    public Optional<DrugEntity> findDrugById(Long id) {

        try {
            return Optional.ofNullable(drugEntityRepository.findById(id).orElseThrow(() ->
                    new NotFoundException("O id do medicamento não foi encontrado no banco de dados. Verifique se está correto.")));

        }catch (Exception e){
            throw new BadRequestException("O medicamento solicitado não foi encontrado. Mensagem localizada:" + e.getLocalizedMessage());
        }
    }


    public DrugEntity updateDrugById(Long id, DrugDTO drugDTO){

        try {
            DrugEntity drug = drugEntityRepository.findById(id).orElseThrow(()->
                    new NotFoundException("O id do medicamento não foi encontrado no banco de dados."));

            drug.setDrugName(drugDTO.getDrugName());
            drug.setLab(drugDTO.getLab());
            drug.setDosage(drugDTO.getDosage());
            drug.setDescription(drugDTO.getDescription());
            drug.setPrice(drugDTO.getPrice());
            drug.setType(drugDTO.getType());

            return drugEntityRepository.save(drug);

        }catch (Exception e){
            throw new ServerSideException("Erro ao atualizar a farmácia. Mensagem localizada: " + e.getLocalizedMessage());
        }
    }


    public DrugEntity deleteDrugById (Long id){

        try {
            drugEntityRepository.deleteById(id);
            return null;

        }catch (Exception e){
            throw new BadRequestException("A farmácia solicitada não foi encontrada. Mensagem localizada:" + e.getLocalizedMessage());
        }
    }
}

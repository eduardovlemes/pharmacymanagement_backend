package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.DTO.DrugDTO;
import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.repository.DrugEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugEntityService {

    @Autowired
    private DrugEntityRepository drugEntityRepository;

    public void saveDrug(DrugEntity drugEntity){
        drugEntityRepository.save(drugEntity);
    }

    public List<DrugEntity> getAll(){
        return (List<DrugEntity>) drugEntityRepository.findAll();
    }

    public Long update(Long id, DrugDTO drugDTO){
        DrugEntity drug = findDrugById(id);
        drug.setDrugName(drugDTO.getDrugName());
        drug.setLab(drugDTO.getLab());
        drug.setDosage(drugDTO.getDosage());
        drug.setDescription(drugDTO.getDescription());
        drug.setPrice(drugDTO.getPrice());
        drug.setType(drugDTO.getType());

        saveDrug(drug);
        return id;
    }

    public void delete(Long id){
        DrugEntity drugEntity = findDrugById(id);
        drugEntityRepository.delete(drugEntity);}

    public DrugEntity findDrugById(Long id){
        return this.drugEntityRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Não existe medicamento com esse id."));
    }
}

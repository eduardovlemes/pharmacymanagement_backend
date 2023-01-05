package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.repository.DrugEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugEntityService {

    @Autowired
    private DrugEntityRepository drugEntityRepository;

    public void save(DrugEntity drugEntity){drugEntityRepository.save(drugEntity);}

    public List<DrugEntity> findAll(){return (List<DrugEntity>) drugEntityRepository.findAll();}

    public DrugEntity findById(Long id){return drugEntityRepository.findById(id).get();}

    public void update(DrugEntity drugEntity){drugEntityRepository.save(drugEntity);}
}

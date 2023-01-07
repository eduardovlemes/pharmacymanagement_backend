package br.com.project.PharmacyManagement.controller;


import br.com.project.PharmacyManagement.DTO.DrugDTO;
import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.service.DrugEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class DrugEntityController {

    @Autowired
    DrugEntityService drugEntityService;

    @PostMapping
    public ResponseEntity<DrugEntity> register(@RequestBody DrugEntity drugEntity){
        drugEntityService.saveDrug(drugEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<DrugEntity> listALl() {
        return drugEntityService.getAll();
    }

    @GetMapping("/{id}")
    public DrugEntity getById (@PathVariable Long id){
        return drugEntityService.findDrugById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id,
                                       @RequestBody DrugDTO drugDTO){
        drugEntityService.update(id, drugDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id){
        drugEntityService.delete(id);
    }
}

package br.com.project.PharmacyManagement.controller;


import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.service.DrugEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class DrugEntityController {

    @Autowired
    DrugEntityService drugEntityService;

    @PostMapping
    public void register(@RequestBody DrugEntity drugEntity){drugEntityService.save(drugEntity);}

    @GetMapping
    public List<DrugEntity> listALl() {return drugEntityService.findAll();}

    @GetMapping("/{id}")
    public DrugEntity getById (@PathVariable Long id){return drugEntityService.findById(id);}
}

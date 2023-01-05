package br.com.project.PharmacyManagement.controller;


import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.service.DrugEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicamentos")
public class DrugEntityController {

    @Autowired
    DrugEntityService drugEntityService;

    @PostMapping
    public void register(@RequestBody DrugEntity drugEntity){drugEntityService.save(drugEntity);}
}

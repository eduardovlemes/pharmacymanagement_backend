package br.com.project.PharmacyManagement.controller;


import br.com.project.PharmacyManagement.DTO.DefaultErrorResponse.DefaultResponse;
import br.com.project.PharmacyManagement.DTO.DrugDTO;
import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.service.DrugEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class DrugEntityController {

    @Autowired
    DrugEntityService drugEntityService;


    @PostMapping
    public ResponseEntity<DefaultResponse> createDrug(
            @RequestBody @Valid DrugDTO drugDTO){

        DrugEntity drug = drugEntityService.saveDrug(drugDTO);

        return new ResponseEntity<>(
                new DefaultResponse<DrugEntity>(
                        HttpStatus.CREATED.value(),
                        drug,
                        "Medicamento cadastrado com sucesso!"
                ),
                HttpStatus.CREATED
        );
    }


    @GetMapping
    public ResponseEntity<DefaultResponse> getALlDrugs() {

        List<DrugEntity> drugs = drugEntityService.findAllDrugs();

        return new ResponseEntity<>(
                new DefaultResponse<List<DrugEntity>>(
                        HttpStatus.OK.value(),
                        drugs,
                        "Medicamento encontrado com sucesso!"
                ),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getDrugById (@PathVariable Long id){

        Optional<DrugEntity> drug = drugEntityService.findDrugById(id);

        return new ResponseEntity<>(
                new DefaultResponse<Optional<DrugEntity>>(
                        HttpStatus.OK.value(),
                        drug,
                        "Medicamento encontrado com sucesso!"
                ),
                HttpStatus.OK
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateDrug(
            @PathVariable Long id,
            @RequestBody @Valid DrugDTO drugDTO){

        DrugEntity drug = drugEntityService.updateDrugById(id, drugDTO);

        return new ResponseEntity<>(
                new DefaultResponse<DrugEntity>(
                        HttpStatus.OK.value(),
                        drug,
                        "Medicamento encontrado com sucesso!"
                ),
                HttpStatus.OK
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteDrug(
            @PathVariable Long id){

        DrugEntity drug = drugEntityService.deleteDrugById(id);

        return new ResponseEntity<>(
                new DefaultResponse<DrugEntity>(
                        HttpStatus.ACCEPTED.value(),
                        drug,
                        "Medicamento deletado com sucesso!"
                ),
                HttpStatus.ACCEPTED
        );
    }
}

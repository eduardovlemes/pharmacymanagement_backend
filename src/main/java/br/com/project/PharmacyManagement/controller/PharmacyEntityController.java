package br.com.project.PharmacyManagement.controller;


import br.com.project.PharmacyManagement.DTO.DefaultErrorResponse.DefaultResponse;
import br.com.project.PharmacyManagement.DTO.PharmacyDTO;
import br.com.project.PharmacyManagement.model.PharmacyEntity;
import br.com.project.PharmacyManagement.service.PharmacyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacia")
public class PharmacyEntityController {

    @Autowired
    private PharmacyEntityService pharmacyEntityService;


    @PostMapping
    public ResponseEntity<DefaultResponse> createPharmacy(
            @Valid @RequestBody PharmacyDTO pharmacyDTO){

        PharmacyEntity pharmacy = pharmacyEntityService.savePharmacyAndAddress(pharmacyDTO);

        return new ResponseEntity<>(
                new DefaultResponse<PharmacyEntity>(
                        HttpStatus.CREATED.value(),
                        pharmacy,
                        "Farmácia cadastrada com sucesso!"
                ),
                HttpStatus.CREATED
        );
    }


    @GetMapping
    public ResponseEntity<DefaultResponse> getAllPharmacy(){

        List<PharmacyEntity> pharmacies = pharmacyEntityService.findAllPharmacies();

        return new ResponseEntity<>(
                new DefaultResponse<List<PharmacyEntity>>(
                        HttpStatus.OK.value(),
                        pharmacies,
                        "Farmácias encontradas com sucesso!"
                ),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getPharmacyById(@PathVariable Long id) {

        Optional<PharmacyEntity> pharmacy = pharmacyEntityService.findPharmacyById(id);

        return new ResponseEntity<>(
                new DefaultResponse<Optional<PharmacyEntity>>(
                        HttpStatus.OK.value(),
                        pharmacy,
                        "Farmácia encontrada com sucesso!"
                ),
                HttpStatus.OK
        );
    }


    @PutMapping("/{id}")
    public  ResponseEntity<DefaultResponse> updatePharmacy(
            @PathVariable Long id,
            @RequestBody PharmacyDTO pharmacyDTO){

        PharmacyEntity pharmacy = pharmacyEntityService.updatePharmacyById(id, pharmacyDTO);

        return new ResponseEntity<>(
                new DefaultResponse<PharmacyEntity>(
                        HttpStatus.OK.value(),
                        pharmacy,
                        "Farmácia atualizada com sucesso!"
                ),
                HttpStatus.OK
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deletePharmacy(
            @PathVariable Long id){

        PharmacyEntity pharmacy = pharmacyEntityService.deletePharmacyById(id);

        return new ResponseEntity<>(
                new DefaultResponse<PharmacyEntity>(
                        HttpStatus.ACCEPTED.value(),
                        pharmacy,
                        "Farmácia deletada com sucesso!"
                ),
                HttpStatus.ACCEPTED
        );
    }
}

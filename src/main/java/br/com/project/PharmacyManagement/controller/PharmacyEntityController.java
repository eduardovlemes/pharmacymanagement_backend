package br.com.project.PharmacyManagement.controller;


import br.com.project.PharmacyManagement.DTO.PharmacyDTO;
import br.com.project.PharmacyManagement.model.PharmacyEntity;
import br.com.project.PharmacyManagement.service.PharmacyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/farmacia")
public class PharmacyEntityController {

    @Autowired
    private PharmacyEntityService pharmacyEntityService;

    @PostMapping
    public ResponseEntity<PharmacyEntity> createPharmacy(
            @Valid @RequestBody PharmacyDTO pharmacyDTO){
        PharmacyEntity pharmacy = pharmacyEntityService.fromDTO(pharmacyDTO);

        PharmacyEntity savedPharmacy = pharmacyEntityService.savePharmacy(pharmacy);

        return ResponseEntity.ok(savedPharmacy);
    }
}

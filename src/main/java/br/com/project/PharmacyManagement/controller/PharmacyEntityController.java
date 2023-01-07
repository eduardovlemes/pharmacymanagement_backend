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

@RestController
@RequestMapping("/farmacia")
public class PharmacyEntityController {

    @Autowired
    private PharmacyEntityService pharmacyEntityService;

    @PostMapping
    public ResponseEntity<PharmacyEntity> register(
            @RequestBody PharmacyDTO pharmacyDTO
            ){
        PharmacyEntity pharmacy = pharmacyEntityService.savePharmacy(pharmacyDTO);

        return ResponseEntity.ok(pharmacy);
    }
}

package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.repository.AddressEntityRepository;
import br.com.project.PharmacyManagement.repository.PharmacyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressEntityService {

    @Autowired
    private AddressEntityRepository addressEntityRepository;

    @Autowired
    private PharmacyEntityRepository pharmacyEntityRepository;

}

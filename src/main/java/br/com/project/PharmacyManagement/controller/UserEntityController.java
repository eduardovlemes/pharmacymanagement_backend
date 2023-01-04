package br.com.project.PharmacyManagement.controller;

import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserEntityController {

    @Autowired
    UserEntityService userEntityService;

    @PostMapping("/cadastro")
    public void register(@RequestBody UserEntity userEntity){
        userEntityService.save(userEntity);
    }
}

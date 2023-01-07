package br.com.project.PharmacyManagement.controller;

import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserEntityController {

    @Autowired
    UserEntityService userEntityService;

    @PostMapping("/cadastro")
    public void register(@RequestBody UserEntity userEntity){
        userEntityService.save(userEntity);
    }


    @GetMapping("/login")
    public ResponseEntity<UserEntity> login(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password
    ) {
        UserEntity login = userEntityService.findByEmail(email);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

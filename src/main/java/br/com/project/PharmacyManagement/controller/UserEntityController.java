package br.com.project.PharmacyManagement.controller;

import br.com.project.PharmacyManagement.DTO.DefaultErrorResponse.DefaultResponse;
import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.security.PMJwtAuthenticationProvider;
import br.com.project.PharmacyManagement.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserEntityController {

    @Autowired
    UserEntityService userEntityService;

    @Autowired
    PMJwtAuthenticationProvider provider;


    @PostMapping("/cadastro")
    public ResponseEntity<DefaultResponse> createUser(
            @RequestBody @Valid UserEntity userEntity){

            UserEntity user = userEntityService.saveUser(userEntity);

            return new ResponseEntity<>(
                    new DefaultResponse<UserEntity>(
                            HttpStatus.CREATED.value(),
                            user,
                            "Usuário(a) cadastrado(a) com sucesso!"
                    ),
                    HttpStatus.CREATED
            );
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody @Valid UserEntity user) {

        boolean authorized = userEntityService.isAuthorized(user);

        if(authorized){
            String s = provider.generateToken(user.getUsername());
            return new ResponseEntity<String>(s, HttpStatus.OK);
        }

        return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
    }
}

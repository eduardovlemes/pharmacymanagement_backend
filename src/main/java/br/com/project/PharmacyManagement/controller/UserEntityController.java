package br.com.project.PharmacyManagement.controller;

import br.com.project.PharmacyManagement.DTO.DefaultErrorResponse.DefaultResponse;
import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserEntityController {

    @Autowired
    UserEntityService userEntityService;


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

    @GetMapping("/login")
    public ResponseEntity<DefaultResponse> login(
            @RequestBody @Valid UserEntity user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

       userEntityService.loadUserByUsername(user.getUsername());

        //Long id = userEntityService.loadUserByUsername(user);

        return new ResponseEntity<>(
                new DefaultResponse<UserEntity>(
                        HttpStatus.OK.value(),
                        user,
                        "Id encontrado com sucesso!"
                ),
                HttpStatus.OK
        );
    }
}

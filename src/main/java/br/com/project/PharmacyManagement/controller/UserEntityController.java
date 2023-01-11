package br.com.project.PharmacyManagement.controller;

import br.com.project.PharmacyManagement.DTO.DefaultErrorResponse.DefaultResponse;
import br.com.project.PharmacyManagement.DTO.UserDTO;
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
    public ResponseEntity<DefaultResponse> createUser(
            @RequestBody UserDTO userDTO){

            UserEntity user = userEntityService.saveUser(userDTO);

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
            @RequestBody UserDTO userDTO) {

        Long id = userEntityService.findByEmailAndPassword(userDTO);

        return new ResponseEntity<>(
                new DefaultResponse<Long>(
                        HttpStatus.OK.value(),
                        id,
                        "Id encontrado com sucesso!"
                ),
                HttpStatus.OK
        );
    }
}

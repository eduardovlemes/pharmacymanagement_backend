package br.com.project.PharmacyManagement.controller;

import br.com.project.PharmacyManagement.DTO.UserDTO;
import br.com.project.PharmacyManagement.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserEntityController {

    @Autowired
    UserEntityService userEntityService;

//    @PostMapping("/cadastro")
//    public void register(@RequestBody UserEntity userEntity){
//        userEntityService.save(userEntity);
//    }


    @PostMapping("/cadastro")
    public ResponseEntity<Void> register(@RequestBody UserDTO userDTO){
        try {
            userEntityService.saveUser(userDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



//    @GetMapping("/login")
//    public ResponseEntity<UserEntity> login(
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) String password
//    ) {
//        UserEntity login = userEntityService.findByEmail(email);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/login")
    public ResponseEntity<Long> login(
            @RequestBody UserDTO userDTO) {

        try{
           Long id = userEntityService.findByEmailAndPassword(userDTO);

           return new ResponseEntity<>(id, HttpStatus.OK);

        } catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

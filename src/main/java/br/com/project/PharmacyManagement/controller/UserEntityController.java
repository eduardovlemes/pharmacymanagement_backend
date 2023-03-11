package br.com.project.PharmacyManagement.controller;

import br.com.project.PharmacyManagement.controller.auth.AuthenticationRequest;
import br.com.project.PharmacyManagement.controller.auth.AuthenticationResponse;
import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserEntityController {

    private final UserEntityService userEntityService;

    @PostMapping("/cadastro")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserEntity userEntity
    ) {
        return ResponseEntity.ok(userEntityService.register(userEntity));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(userEntityService.authenticate(request));
    }
}

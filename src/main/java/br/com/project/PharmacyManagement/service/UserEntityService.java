package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    public void save(UserEntity userEntity){
        userEntityRepository.save(userEntity);
    }

    public UserEntity findByEmail(String email) {
        return userEntityRepository.findUserByEmail(email).get();
    }
}

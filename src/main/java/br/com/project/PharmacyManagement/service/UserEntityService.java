package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.DTO.UserDTO;
import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.repository.UserEntityRepository;
import br.com.project.PharmacyManagement.service.exception.ServerSideException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

//    public void save(UserEntity userEntity){
//        userEntityRepository.save(userEntity);
//    }

    public void saveUser (UserDTO userDTO){

        try {
            UserEntity user = new UserEntity();
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());

            userEntityRepository.save(user);
        } catch (Exception e){
            throw new ServerSideException("Erro ao salvar o usuário: " + e.getLocalizedMessage());
        }

    }

//    public UserEntity findByEmail(String email) {
//        return userEntityRepository.findUserByEmail(email).get();
//    }
    public Long findByEmailAndPassword(UserDTO userDTO) {

        UserEntity user = userEntityRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());

        if (user == null) {
            throw new EntityNotFoundException("Usuário ou senha não encontrado.");
        }
        return user.getId();
    }
}

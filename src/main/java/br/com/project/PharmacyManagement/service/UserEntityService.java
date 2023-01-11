package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.DTO.UserDTO;
import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.repository.UserEntityRepository;
import br.com.project.PharmacyManagement.service.exception.NotFoundException;
import br.com.project.PharmacyManagement.service.exception.ServerSideException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;


    public UserEntity saveUser (UserDTO userDTO){

        try {
            UserEntity user = new UserEntity();
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());

            return userEntityRepository.save(user);
        } catch (Exception e){
            throw new ServerSideException("Erro ao salvar o usuário. Mensagem localizada: " + e.getLocalizedMessage());
        }
    }

    public Long findByEmailAndPassword(UserDTO userDTO) {

        try {
            UserEntity user = userEntityRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());

            return user.getId();
        } catch (Exception e){
            throw new NotFoundException("O usuário(a) solicitado não foi encontrado. Mensagem localizada:" + e.getLocalizedMessage());
        }
    }
}

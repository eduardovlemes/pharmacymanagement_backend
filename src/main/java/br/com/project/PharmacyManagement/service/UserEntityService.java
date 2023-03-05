package br.com.project.PharmacyManagement.service;

import br.com.project.PharmacyManagement.model.UserEntity;
import br.com.project.PharmacyManagement.repository.UserEntityRepository;
import br.com.project.PharmacyManagement.security.PMJwtAuthenticationProvider;
import br.com.project.PharmacyManagement.service.exception.ServerSideException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;


    public UserEntity saveUser (UserEntity userEntity){

        try {
            UserEntity user = new UserEntity();
            user.setEmail(userEntity.getEmail());
            user.setPassword(new PMJwtAuthenticationProvider().generateToken(userEntity.getPassword()));;
            user.setRoles(userEntity.getRoles());

            return userEntityRepository.save(user);

        } catch (Exception e){
            throw new ServerSideException("Erro ao salvar o usuário. Mensagem localizada: " + e.getLocalizedMessage());
        }
    }

//    public Long findByEmailAndPassword(UserEntity userEntity) {
//
//        try {
//            UserEntity user = userEntityRepository.findByEmail(userEntity.getEmail()); //, userDTO.getPassword()
//
//            return user.getId();
//        } catch (Exception e){
//            throw new NotFoundException("O usuário(a) solicitado não foi encontrado. Mensagem localizada:" + e.getLocalizedMessage());
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userEntityRepository.findByEmail(email);

        if(user == null) {
           throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

}

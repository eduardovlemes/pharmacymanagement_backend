package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email") //AND u.password = :password
    UserEntity findByEmail(@Param("email") String email); //, @Param("password") String password
}

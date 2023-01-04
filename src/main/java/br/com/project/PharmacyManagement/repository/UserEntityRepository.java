package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
}

package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.PharmacyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyEntityRepository extends CrudRepository<PharmacyEntity, Long> {

}

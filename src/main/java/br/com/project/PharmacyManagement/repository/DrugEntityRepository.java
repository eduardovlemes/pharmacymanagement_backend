package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.DrugEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugEntityRepository extends CrudRepository<DrugEntity, Long> {
}

package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.DrugEntity;
import br.com.project.PharmacyManagement.model.PharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugEntityRepository extends JpaRepository<DrugEntity, Long> {

    @NonNull
    Optional<PharmacyEntity> findDrugById(@NonNull Long id);
}

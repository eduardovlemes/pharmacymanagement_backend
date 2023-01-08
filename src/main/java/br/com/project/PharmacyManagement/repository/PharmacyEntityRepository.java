package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.PharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PharmacyEntityRepository extends JpaRepository<PharmacyEntity, Long> {
    @NonNull
    Optional<PharmacyEntity> findById(@NonNull Long id);

}

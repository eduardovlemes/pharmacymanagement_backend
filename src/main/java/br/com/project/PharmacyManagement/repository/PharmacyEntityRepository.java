package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.PharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyEntityRepository extends JpaRepository<PharmacyEntity, Long> {

}

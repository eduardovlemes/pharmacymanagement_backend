package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends JpaRepository<AddressEntity, Long> {
}

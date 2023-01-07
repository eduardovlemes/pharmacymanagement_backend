package br.com.project.PharmacyManagement.repository;

import br.com.project.PharmacyManagement.model.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressEntityRepository extends CrudRepository<AddressEntity, Long> {

    Optional<AddressEntity> findById(Long idAddress);
}

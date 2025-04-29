package one.digitalInnovation.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalInnovation.personapi.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{
    
}

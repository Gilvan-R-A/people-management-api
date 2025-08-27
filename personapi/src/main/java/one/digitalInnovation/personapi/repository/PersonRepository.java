package one.digitalInnovation.personapi.repository;

import one.digitalInnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p LEFT JOIN FETCH p.phones WHERE p.id = :id")
    Optional<Person> findByIdWithPhones(@Param("id") Long id);

    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.phones")
    List<Person> findAllWithPhones();

    Optional<Person> findByCpf(String cpf);

}
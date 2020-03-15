package fr.witentreprise.formation.repositories;

import fr.witentreprise.formation.models.Formation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FormationRepository extends MongoRepository<Formation, String> {
    Optional<Formation> findByDate(LocalDate date);
    Optional<Formation> findByName(String name);
}

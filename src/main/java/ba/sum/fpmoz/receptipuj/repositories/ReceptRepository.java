package ba.sum.fpmoz.receptipuj.repositories;

import ba.sum.fpmoz.receptipuj.models.Recept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptRepository extends JpaRepository<Recept, Integer> {
    // Custom query to find all recipes by a user's ID
    List<Recept> findByKorisnikId(Integer korisnikId);
}



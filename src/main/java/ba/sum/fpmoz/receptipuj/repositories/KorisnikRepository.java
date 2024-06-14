package ba.sum.fpmoz.receptipuj.repositories;

import ba.sum.fpmoz.receptipuj.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

    Korisnik findByKorisnickoIme(String korisnickoIme);
    Optional<Korisnik> findByEmail(String email);

}




package ba.sum.fpmoz.receptipuj.services;

import ba.sum.fpmoz.receptipuj.models.Recept;
import ba.sum.fpmoz.receptipuj.repositories.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptService {
    @Autowired
    private ReceptRepository receptRepository;

    public Recept saveRecept(Recept recept) {
        return receptRepository.save(recept);
    }

    public List<Recept> findAllRecepti() {
        return receptRepository.findAll();
    }

    public Optional<Recept> getReceptById(int id) {
        return receptRepository.findById(id);
    }

    public void deleteRecept(int id) {
        receptRepository.deleteById(id);
    }

    public List<Recept> findByKorisnikId(Integer userId) {
        // Assuming that there's a method in the repository to find recipes by user id
        return receptRepository.findByKorisnikId(userId);
    }

    @Transactional
    public Recept updateRecept(Integer id, Recept updatedRecept) {
        return receptRepository.findById(id)
                .map(recept -> {
                    recept.setNaslov(updatedRecept.getNaslov());
                    recept.setOpis(updatedRecept.getOpis());
                    recept.setSastojci(updatedRecept.getSastojci());
                    recept.setPostupak(updatedRecept.getPostupak());
                    recept.setVrijemePripreme(updatedRecept.getVrijemePripreme());
                    return receptRepository.save(recept);
                })
                .orElseThrow(() -> new RuntimeException("Recept not found with id " + id));
    }
}

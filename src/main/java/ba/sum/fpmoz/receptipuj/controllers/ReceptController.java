package ba.sum.fpmoz.receptipuj.controllers;
import ba.sum.fpmoz.receptipuj.models.Recept;
import ba.sum.fpmoz.receptipuj.services.ReceptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recepti")
public class ReceptController {

    @Autowired
    private ReceptService receptService;

    @GetMapping("/dodaj")
    public String showAddReceptForm(Model model) {
        model.addAttribute("recept", new Recept());
        return "dodajRecept";
    }

    @PostMapping
    public String addRecept(@Valid @ModelAttribute Recept recept) {
        receptService.saveRecept(recept);
        return "redirect:/home";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recept> getReceptById(@PathVariable Integer id) {
        return receptService.getReceptById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recept>> getReceptiByUserId(@PathVariable Integer userId) {
        List<Recept> recepti = receptService.findByKorisnikId(userId);
        if (recepti.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recepti);
    }

    @GetMapping
    public String getAllRecepti(Model model) {
        List<Recept> recepti = receptService.findAllRecepti();
        model.addAttribute("recepti", recepti);
        return "home";
    }

    @GetMapping("/uredi/{id}")
    public String showEditReceptForm(@PathVariable Integer id, Model model) {
        Recept recept = receptService.getReceptById(id)
                .orElseThrow(() -> new RuntimeException("Recept not found with id " + id));
        model.addAttribute("recept", recept);
        return "urediRecept";
    }

    @PostMapping("/uredi/{id}")
    public String updateRecept(@PathVariable Integer id, @Valid @ModelAttribute Recept updatedRecept) {
        receptService.updateRecept(id, updatedRecept);
        return "redirect:/home";
    }

    @GetMapping("/izbrisi/{id}")
    public String deleteRecept(@PathVariable Integer id) {
        receptService.deleteRecept(id);
        return "redirect:/home";
    }
}




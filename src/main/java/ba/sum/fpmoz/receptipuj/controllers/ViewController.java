package ba.sum.fpmoz.receptipuj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ba.sum.fpmoz.receptipuj.models.Recept;
import ba.sum.fpmoz.receptipuj.services.ReceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private ReceptService receptService;

    @GetMapping("/login_page")
    public String login() {
        return "loginJava";  // Name of the HTML file under src/main/resources/templates
    }

    @GetMapping("/register")
    public String register() {
        return "register";  // Name of the HTML file under src/main/resources/templates
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Recept> recepti = receptService.findAllRecepti();
        model.addAttribute("recepti", recepti);
        return "home";
    }

    @GetMapping("/dodaj")
    public String dodaj() {
        return "dodajRecept";
    }

    @GetMapping("/uredi")
    public String uredi() {
        return "urediRecept";
    }
}


package cat.itb.projectespring.controlador;

import cat.itb.projectespring.model.entitat.Producte;
import cat.itb.projectespring.model.servei.ProducteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProducteController {

    @Autowired
    private ProducteService serveiProducte;
    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeProducte(@PathVariable("name") String producte){
        serveiProducte.removeProductebyName(producte);
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String llistarProducte(Model m){
        m.addAttribute("llistaProducte", serveiProducte.llistat());
        m.addAttribute("Producte",new Producte());
        return "home";
    }
    @RequestMapping("/afegir")
    public String afegirProducte(Model model) {
        model.addAttribute("Producte", new Producte());
        return "afegirProducte";
    }
    @PostMapping("/afegirProducte")
//empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
//https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String AfegirProducte(@ModelAttribute("Producte") Producte e){
        serveiProducte.afegir(e);
        return "redirect:/home";
    }
    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateProducte(@PathVariable("name") String producte, Model m){
        m.addAttribute("Producte", serveiProducte.consultaPerNom(producte));
        return "/updateProducte";
    }
    @PostMapping("/updateProducte")
//empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
//https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String updateProductepost(@ModelAttribute("Producte") Producte e){
        serveiProducte.updateProducte(e);
        return "redirect:/home";
    }
}

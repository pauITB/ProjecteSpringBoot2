package cat.itb.projectespring.controlador;



import cat.itb.projectespring.model.entitat.Productes;
import cat.itb.projectespring.model.entitat.Usuari;
import cat.itb.projectespring.model.servei.ProducteService;
import cat.itb.projectespring.model.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Controlador {

    String nom;
    @Autowired
    private UserService servei;
    @Autowired
    private ProducteService serveiProducte;


    @GetMapping("/")
    public  String  inici(Model m){
        m.addAttribute("llistaProducte", serveiProducte.llistat());
        m.addAttribute("Producte",new Productes());
        return "home";
    }


    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeProducte(@PathVariable("name") String producte){



        serveiProducte.removeProductebyName(producte);
        return "redirect:/";
    }







    @GetMapping("/userList")
    public String llistar(Model m){
        m.addAttribute("llistaUsuaris",servei.llistat());
        return "llistatUsuaris";
    }









    @GetMapping("/home")
    public String llistarProducte(Model m){
        m.addAttribute("llistaProducte", serveiProducte.llistat());
        m.addAttribute("Producte",new Productes());
        return "home";
    }


    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("usuari", new Usuari());
        return "register";
    }

    @RequestMapping("/afegir")
    public String afegirProducte(Model model) {
        model.addAttribute("Producte", new Productes());
        return "afegirProducte";
    }

    @PostMapping("/afegirProducte")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String AfegirProducte(@ModelAttribute("Producte") Productes e){
        serveiProducte.afegir(e);
        return "redirect:/";

    }




    @PostMapping("/registration")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("usuari") Usuari e){
        e.setRol("USER");
        servei.afegir(e);
        return "redirect:/list";

    }

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateProducte(@PathVariable("name") String producte, Model m){

        nom = producte;
        m.addAttribute("Producte", serveiProducte.consultaPerNom(producte));

        return "/updateProducte";
    }

    @PostMapping("/updateProducte")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String updateProductepost(@ModelAttribute("Producte") Productes e){
        serveiProducte.updateProducte(e);
        return "redirect:/";

    }


}





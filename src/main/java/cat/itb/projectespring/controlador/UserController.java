package cat.itb.projectespring.controlador;




import cat.itb.projectespring.model.entitat.Usuari;

import cat.itb.projectespring.model.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {

    @Autowired
    private UserService servei;

    @GetMapping("/")
    public  String  inici(){
        return "index";
    }

    @GetMapping("/userList")
    public String llistar(Model m){
        m.addAttribute("llistaUsuaris",servei.llistat());
        return "llistatUsuaris";
    }


    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("usuari", new Usuari());
        return "register";
    }


    @PostMapping("/registration")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("usuari") Usuari e){
        e.setRol("USER");
        servei.afegir(e);
        return "redirect:/list";

    }


}





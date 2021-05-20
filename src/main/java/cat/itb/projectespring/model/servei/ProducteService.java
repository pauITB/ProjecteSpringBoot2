package cat.itb.projectespring.model.servei;

import cat.itb.projectespring.model.entitat.Productes;
import cat.itb.projectespring.model.repositori.RepositoriProducte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProducteService {

    @Autowired
    private RepositoriProducte repositori;

    public void afegir(Productes e) {
        repositori.save(e);
    }

    public List<Productes> llistat() {
        List<Productes> productes = new ArrayList<>();
        repositori.findAll().forEach(productes::add);
        return productes;
    }

    @PostConstruct
    public void init() {
        repositori.save(new Productes("Iphone", 12));
        repositori.save(new Productes("Pizzas", 24));
        repositori.save(new Productes("Erizo", 1));
    }


    public Productes consultaPerNom(String nomProducte) {

        return  repositori.findById(nomProducte).get();
    }

    public void removeProductebyName(String s){
        repositori.deleteById(s);
    }

    public void updateProducte(Productes e){
        repositori.save(e);

    }






}

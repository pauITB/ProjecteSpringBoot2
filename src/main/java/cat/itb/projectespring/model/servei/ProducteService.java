package cat.itb.projectespring.model.servei;

import cat.itb.projectespring.model.entitat.Producte;
import cat.itb.projectespring.model.repositori.RepositoriProducte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProducteService {

    @Autowired
    private RepositoriProducte repository;

    public void afegir(Producte e) {
        repository.save(e);
    }

    public List<Producte> llistat() {
        List<Producte> productes = new ArrayList<>();
        repository.findAll().forEach(productes::add);
        return productes;
    }

    @PostConstruct
    public void init() {
        repository.save(new Producte("Iphone", 12));
        repository.save(new Producte("Pizzas", 24));
        repository.save(new Producte("Erizo", 1));
    }


    public Producte consultaPerNom(String nomProducte) {

        return  repository.findById(nomProducte).orElse(null);
    }

    public void removeProductebyName(String s){
        repository.deleteById(s);
    }

    public void updateProducte(Producte e){
        repository.save(e);

    }
}

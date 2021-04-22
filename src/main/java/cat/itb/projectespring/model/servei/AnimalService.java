package cat.itb.projectespring.model.servei;

import cat.itb.projectespring.model.entitat.Animal;
import cat.itb.projectespring.model.entitat.Usuari;
import cat.itb.projectespring.model.repositori.RepositoriAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private RepositoriAnimal repositori;

    public void afegir(Animal e) {
        repositori.save(e);
    }

    public List<Animal> llistat() {
        List<Animal> animals = new ArrayList<>();
        repositori.findAll().forEach(animals::add);
        return animals;
    }

    @PostConstruct
    public void init() {
        repositori.save(new Animal("Perro", "Verde"));
        repositori.save(new Animal("Pantera", "Rosa"));
        repositori.save(new Animal("Erizo", "Azul"));
    }


    public Animal consultaPerNom(String id) {

        return  repositori.findById(id).get();
    }

    public void removeAnimalbyName(String s){
        repositori.deleteById(s);
    }

    public void updateAnimal(Animal e){
        repositori.save(e);

    }






}

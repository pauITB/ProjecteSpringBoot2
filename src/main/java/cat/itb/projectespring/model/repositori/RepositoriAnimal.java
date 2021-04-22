package cat.itb.projectespring.model.repositori;

import cat.itb.projectespring.model.entitat.Animal;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriAnimal extends CrudRepository<Animal,String> {
}

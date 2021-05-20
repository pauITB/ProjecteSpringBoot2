package cat.itb.projectespring.model.repositori;

import cat.itb.projectespring.model.entitat.Productes;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriProducte extends CrudRepository<Productes,String> {
}

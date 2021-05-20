package cat.itb.projectespring.model.repositori;

import cat.itb.projectespring.model.entitat.Producte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface RepositoriProducte extends CrudRepository<Producte,String> {
}

package cat.itb.projectespring.model.repositori;

import cat.itb.projectespring.model.entitat.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuari extends CrudRepository<Usuari,String> {
}

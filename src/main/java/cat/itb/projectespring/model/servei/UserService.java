package cat.itb.projectespring.model.servei;



import cat.itb.projectespring.model.entitat.Usuari;
import cat.itb.projectespring.model.repositori.RepositoriUsuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
        private RepositoriUsuari repositori ;

        public void afegir(Usuari e) {
            e.setPassword(passwordEncoder(e.getPassword()));
            repositori.save(e);
        }
        public List<Usuari> llistat() {
            List<Usuari> usuaris = new ArrayList<>();
            repositori.findAll().forEach(usuaris::add);
            return usuaris;
        }

        @PostConstruct
        public void init() {
            repositori.save(new Usuari("user1", passwordEncoder("user1"), "USER"));
            repositori.save(new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN"));

        }


    public Usuari consultaPerId(String s) {
        return repositori.findById(s).get();
    }


    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }
}

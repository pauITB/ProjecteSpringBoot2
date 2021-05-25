package cat.itb.projectespring.model.entitat;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuari {
    @NotNull
    @Id
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String rol;



}

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
public class Producte {

    @NotNull
    @Id
    private String nomProducte;


    private int quantitat;








}

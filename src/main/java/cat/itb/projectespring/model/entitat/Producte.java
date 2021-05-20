package cat.itb.projectespring.model.entitat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producte {
    @NotNull
    @NotEmpty
    @Id
    private String nomProducte;


    private int quantitat;








}

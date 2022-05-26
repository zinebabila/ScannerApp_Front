package scanner.projet.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String numTel;
    private String email;
    private Double solde;
    private String urlImage;
    private String password;
    private String adresse;


}

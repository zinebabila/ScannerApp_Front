package scanner.projet.model.bo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Wallet implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Double solde;


    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @ManyToOne
   @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

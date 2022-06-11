package scanner.projet.model.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="currency")
public class Currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10)
    private String currencyName;
    private Double percentageToDollar;
    private String imageCurrency;
    @OneToMany(mappedBy = "currency")
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Wallet> wallets=new HashSet<>();
    @Column(length = 5)
    private String symbol;

    public Set<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(Set<Wallet> wallets) {
        this.wallets = wallets;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getPercentageToDollar() {
        return percentageToDollar;
    }

    public void setPercentageToDollar(Double percentageToDollar) {
        this.percentageToDollar = percentageToDollar;
    }

    public String getImageCurrency() {
        return imageCurrency;
    }

    public void setImageCurrency(String imageCurrency) {
        this.imageCurrency = imageCurrency;
    }


}

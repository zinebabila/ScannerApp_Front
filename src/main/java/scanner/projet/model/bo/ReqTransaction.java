package scanner.projet.model.bo;

public class ReqTransaction {
    private Long id_user;
    private double somme;
    private Long id_currency;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public Long getId_currency() {
        return id_currency;
    }

    public void setId_currency(Long id_currency) {
        this.id_currency = id_currency;
    }
}

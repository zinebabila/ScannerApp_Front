package scanner.projet.model.bo;

import javax.persistence.*;

@Entity
public class Transaction  {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String dateTransaction;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

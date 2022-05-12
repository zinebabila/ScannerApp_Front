package scanner.projet.model.dao;


import org.springframework.data.repository.CrudRepository;
import scanner.projet.model.bo.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    public Account findByEmail(String email);
}

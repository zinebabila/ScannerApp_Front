package scanner.projet.model.dao;

import org.springframework.data.repository.CrudRepository;

import scanner.projet.model.bo.Account;
import scanner.projet.model.bo.User;

public interface UserRepostory extends CrudRepository<User, Long> {
    public  User findUserByAccount(Account a);
}

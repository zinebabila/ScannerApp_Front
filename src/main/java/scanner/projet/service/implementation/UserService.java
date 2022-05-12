package scanner.projet.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scanner.projet.model.bo.Account;
import scanner.projet.model.bo.User;
import scanner.projet.model.dao.UserRepostory;
import scanner.projet.service.IUserService;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    UserRepostory userRepostory;
    @Autowired
    AccountService accountService;


    @Override
    public User saveUser(User a) {
        return userRepostory.save(a);
    }

    @Override
    public User updateUser(User a) {
        return userRepostory.save(a);
    }

    @Override
    public void deleteUser(Long id) {
userRepostory.deleteById(id);
    }

    @Override
    public User getUserAc(Long id) {
        Account a = accountService.getAccount(id);
        return userRepostory.findUserByAccount(a);
    }

    @Override
    public Collection<User> listUsers() {
        return (Collection<User>) userRepostory.findAll();
    }
}

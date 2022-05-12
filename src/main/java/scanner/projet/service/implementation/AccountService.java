package scanner.projet.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import scanner.projet.model.bo.Account;

import scanner.projet.model.dao.AccountRepository;

import scanner.projet.service.IAccountService;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Autowired
   private PasswordEncoder passwordEncoder;
    @Override
    public Account saveAccount(Account a) {
        return accountRepository.save(a);
    }

    @Override
    public Collection<Account> listAccounts() {
        return (Collection<Account>) accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Account a) {
        return accountRepository.save(a);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }


    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
   }

}
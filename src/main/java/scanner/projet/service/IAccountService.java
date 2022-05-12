package scanner.projet.service;


import scanner.projet.model.bo.Account;

import java.util.Collection;

public interface IAccountService {
    public Account saveAccount(Account a);
    public Account updateAccount(Account a);
    public void deleteAccount(Long id);
    public Account getAccount(Long id);
    public Collection<Account> listAccounts();
}

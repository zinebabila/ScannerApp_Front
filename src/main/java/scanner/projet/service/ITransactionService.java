package scanner.projet.service;


import scanner.projet.model.bo.Transaction;

import java.util.Collection;

public interface ITransactionService {
    public Transaction saveTransaction(Transaction a);
    public Transaction updateTransaction(Transaction a);
    public void deleteTransaction(Long id);
    public Transaction getTransaction(Long id);
    public Collection<Transaction> listTransactions();
}

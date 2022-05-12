package scanner.projet.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scanner.projet.model.bo.Transaction;
import scanner.projet.model.dao.TransactionRepostory;
import scanner.projet.service.ITransactionService;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class TransactionService implements ITransactionService {
    @Autowired
    TransactionRepostory transactionRepostory;
    @Override
    public Transaction saveTransaction(Transaction a) {
        return transactionRepostory.save(a);
    }

    @Override
    public Transaction updateTransaction(Transaction a) {
        return transactionRepostory.save(a);
    }

    @Override
    public void deleteTransaction(Long id) {
transactionRepostory.deleteById(id);
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepostory.findById(id).get();
    }

    @Override
    public Collection<Transaction> listTransactions() {
        return (Collection<Transaction>) transactionRepostory.findAll();
    }
}

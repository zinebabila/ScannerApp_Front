package scanner.projet.model.dao;

import org.springframework.data.repository.CrudRepository;
import scanner.projet.model.bo.Transaction;

public interface TransactionRepostory extends CrudRepository<Transaction, Long> {
}

package scanner.projet.model.dao;

import org.springframework.data.repository.CrudRepository;
import scanner.projet.model.bo.Wallet;

public interface WalletRepostory extends CrudRepository<Wallet, Long> {
}

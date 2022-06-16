package scanner.projet.model.dao;

import org.springframework.data.repository.CrudRepository;

import scanner.projet.model.bo.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}

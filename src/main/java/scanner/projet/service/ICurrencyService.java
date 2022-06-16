package scanner.projet.service;

import scanner.projet.model.bo.Currency;


public interface ICurrencyService {
    Currency findCurrency(Long id);
}

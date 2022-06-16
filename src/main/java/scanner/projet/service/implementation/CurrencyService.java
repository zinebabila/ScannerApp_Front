package scanner.projet.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scanner.projet.model.bo.Currency;
import scanner.projet.model.bo.Image;
import scanner.projet.model.dao.CurrencyRepository;
import scanner.projet.service.ICurrencyService;
@Service
public class CurrencyService implements ICurrencyService {
@Autowired
    CurrencyRepository currencyRepository;
    @Override
    public Currency findCurrency(Long id) {
        return currencyRepository.findById(id).get();
    }
}

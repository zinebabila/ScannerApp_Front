package scanner.projet.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scanner.projet.model.bo.Wallet;
import scanner.projet.model.dao.WalletRepostory;
import scanner.projet.service.IWalletService;

@Service
public class WalletService implements IWalletService {
    @Autowired
    WalletRepostory walletRepostory;
    @Override
    public Wallet modifier(Wallet wallet) {
        return walletRepostory.save(wallet) ;
    }
}

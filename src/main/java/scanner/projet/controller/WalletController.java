package scanner.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scanner.projet.model.bo.*;
import scanner.projet.service.implementation.UserService;
import scanner.projet.service.implementation.WalletService;
@RestController
public class WalletController {
    @Autowired
    WalletService walletService;
    @Autowired
    UserService userService;
    @PostMapping({"/modifierwallet"})
    public ResponseEntity<Wallet> modifierwallet(@RequestBody WalletReq wallet) throws Exception {
        System.out.println("*** here ****");
        wallet.getWallet().setUser(wallet.getUser());
        return new ResponseEntity<>(walletService.modifier(wallet.getWallet()), HttpStatus.OK);
    }
}

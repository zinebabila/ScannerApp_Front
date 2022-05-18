package scanner.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scanner.projet.model.bo.Account;
import scanner.projet.model.bo.RegisterRequest;
import scanner.projet.model.bo.User;
import scanner.projet.service.implementation.AccountService;
import scanner.projet.service.implementation.UserService;

@RestController
public class UserController {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;


    @PostMapping({"/registerNewMerchant"})
    public ResponseEntity<User> registerNewMerchant(@RequestBody RegisterRequest registerRequest) throws Exception {
        System.out.println("*** here ****");
        Account account = new Account();
        account.setEmail(registerRequest.getEmail());
        account.setPassword(accountService.getEncodedPassword(registerRequest.getPassword()));

        System.out.println(registerRequest.getEmail()+"     "+registerRequest.getPassword());
        account = accountService.saveAccount(account);
        User merchant= new User();
        merchant.setFirstName(registerRequest.getFirstName());
        merchant.setLastName(registerRequest.getLastName());
        merchant.setNumTel(registerRequest.getNumTel());
       // merchant.setSolde(registerRequest.getSolde());
        merchant.setUrlImage(registerRequest.getUrlImage());
        merchant.setAccount(account);
        return new ResponseEntity<>(userService.saveUser(merchant)
                , HttpStatus.OK);
    }

    @GetMapping("/User/getOne/{id}")
    public ResponseEntity<User> getOneMerchant(@PathVariable("id") Long id){
        User m=userService.getUserAc(id);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }



}

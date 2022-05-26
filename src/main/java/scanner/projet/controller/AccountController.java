package scanner.projet.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import scanner.projet.model.bo.Account;
import scanner.projet.model.bo.User;
import scanner.projet.service.implementation.AccountService;
import scanner.projet.service.implementation.UserService;

import java.util.List;
@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @PostMapping
    public Account addAccount(@RequestBody Account c)
    {
        return accountService.saveAccount(c);
    }

    @GetMapping("/getAll")
    public List<Account> listAccount() {   return (List<Account>) accountService.listAccounts();}
    @GetMapping(path="/getOne/{id}")
    public Account getAccount(@PathVariable("id") Long idCat) {
        return accountService.getAccount(idCat);
    }
    @PutMapping("/update")
    public Account updateAccount(@RequestBody Account c){
        System.out.println(c);
        Account account=accountService.getAccount(c.getId());
                User user= userService.getUser(c.getUser().getId());
        user.setAdresse(c.getUser().getAdresse());
        user.setFirstName(c.getUser().getFirstName());
        user.setLastName(c.getUser().getLastName());
        user.setNumTel(c.getUser().getNumTel());
        user.setUrlImage(c.getUser().getUrlImage());
        account.setUser(user);

        return accountService.updateAccount(account) ;
     //   return  accountService.updateAccount(c);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable("id") Long idCat){
        accountService.deleteAccount(idCat);
    }


    //@PostConstruct
   // public void initRoleAndUser() {
    //    accountService.initRoleAndUser();
 //  }



    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }


}

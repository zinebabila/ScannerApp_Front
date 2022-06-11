package scanner.projet.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import scanner.projet.model.bo.Account;
import scanner.projet.model.bo.Image;
import scanner.projet.model.bo.User;
import scanner.projet.service.implementation.AccountService;
import scanner.projet.service.implementation.ImageService;
import scanner.projet.service.implementation.UserService;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;
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
    public Account updateAccount(
            @RequestParam("account") Long c,
            @RequestParam("first") String first,
            @RequestParam("last")String last,
            @RequestParam("Phone")String phone,
            @RequestParam("adresse")String adresse,
            @RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("here update account ");
       Image im= imageService.uplaodImage(file);
       Account account=accountService.getAccount(c);
               User user= userService.getUserAc(c);
        user.setAdresse(adresse);
        user.setFirstName(first);
        user.setLastName(last);
        user.setNumTel(phone);

user.setImage(im);
        User u=userService.updateUser(user) ;
 account.setUser(u);

       return  accountService.updateAccount(account);
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

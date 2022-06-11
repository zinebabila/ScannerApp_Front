package scanner.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import scanner.projet.model.bo.Account;
import scanner.projet.model.bo.Image;
import scanner.projet.model.bo.RegisterRequest;
import scanner.projet.model.bo.User;
import scanner.projet.service.implementation.AccountService;
import scanner.projet.service.implementation.ImageService;
import scanner.projet.service.implementation.UserService;

@RestController
public class UserController {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;


    @PostMapping({"/registerNewMerchant"})
    public ResponseEntity<User> registerNewMerchant( @RequestParam("first")String first,
                                                     @RequestParam("last")String last,
                                                     @RequestParam("Phone")String phone,
                                                     @RequestParam("adresse")String adresse,
                                                     @RequestParam("imageFile") MultipartFile file ,
                                                     @RequestParam("email")String email,
                                                     @RequestParam("password")String password) throws Exception {
        System.out.println("*** here ****");
        Image im= imageService.uplaodImage(file);
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(accountService.getEncodedPassword(password));

        System.out.println(email+"     "+password);
        account = accountService.saveAccount(account);
        User merchant= new User();
        merchant.setFirstName(first);
        merchant.setLastName(last);
        merchant.setNumTel(phone);
        merchant.setAdresse(adresse);
        merchant.setImage(im);
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

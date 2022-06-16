package scanner.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scanner.projet.model.bo.Currency;
import scanner.projet.model.bo.ReqTransaction;
import scanner.projet.model.bo.Transaction;
import scanner.projet.model.bo.User;
import scanner.projet.service.implementation.CurrencyService;
import scanner.projet.service.implementation.TransactionService;
import scanner.projet.service.implementation.UserService;

import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    UserService userService;
    @PostMapping
    public Transaction addTransaction(@RequestBody ReqTransaction c)
    {
        Transaction t=new Transaction();
        Currency currency=currencyService.findCurrency(c.getId_currency());
        User user=userService.getUserAc(c.getId_user());
        t.setSomme(c.getSomme());
        t.setCurrency(currency);
        t.setUser(user);
        return transactionService.saveTransaction(t);
    }

    @GetMapping("/getAll")
    public List<Transaction> listTransaction() {   return (List<Transaction>) transactionService.listTransactions();}

    @GetMapping(path="/getOne/{id}")
    public Transaction getTransaction(@PathVariable("id") Long idCat) {
        return transactionService.getTransaction(idCat);
    }
    @PutMapping("/update")
    public Transaction updateTransaction(@RequestBody Transaction c){
        return  transactionService.updateTransaction(c);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable("id") Long idCat){
        transactionService.deleteTransaction(idCat);
    }
}

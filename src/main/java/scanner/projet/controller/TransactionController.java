package scanner.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scanner.projet.model.bo.Transaction;
import scanner.projet.service.implementation.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping
    public Transaction addCompte(@RequestBody Transaction c)
    {
        return transactionService.saveTransaction(c);
    }

    @GetMapping("/getAll")
    public List<Transaction> listCategorie() {   return (List<Transaction>) transactionService.listTransactions();}

    @GetMapping(path="/getOne/{id}")
    public Transaction getCategorie(@PathVariable("id") Long idCat) {
        return transactionService.getTransaction(idCat);
    }
    @PutMapping("/update")
    public Transaction updateCategorie(@RequestBody Transaction c){
        return  transactionService.updateTransaction(c);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCate(@PathVariable("id") Long idCat){
        transactionService.deleteTransaction(idCat);
    }
}

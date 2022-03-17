package kr.practice.practice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.practice.practice.Account.Account;
import kr.practice.practice.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository repository;


    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/accounts")
    public List<Account> all() {
        return repository.findAll();
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account newAccount){
        return repository.save(newAccount);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount (@PathVariable Long id)  {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("illegal argument : " + id));
    }

    @PutMapping("/accounts/{id}")
    Account replaceAccount(@RequestBody Account newAccount, @PathVariable Long id){
        return  repository.findById(id)
                .map(account -> {
                    account.setName(newAccount.getName());
                    return repository.save(account);
                })
                .orElseGet(()->{
                    newAccount.setId(id);
                    return repository.save(newAccount);
                });
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable Long id){
        repository.deleteAllById(id);
    }

}

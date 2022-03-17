package kr.practice.practice.controller;

import kr.practice.practice.Account.Account;
import kr.practice.practice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountApiController {


    // 생성자 주입으로 AccountRepository를 주입시켜준다.
    private final AccountRepository accountRepository;

    //생성
    @PostMapping("/account")
    public Account saveAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }


    @PutMapping("/{AccountNUm}")
    public void updateAccount(@PathVariable Long AccountNUm, @RequestBody Account newAccount){
        accountRepository.findById(AccountNUm)
                .map(account -> {
                    account.setName(newAccount.getName());
                    return accountRepository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setAccountNUm(AccountNUm);
                    return accountRepository.save(newAccount);
                });
    }


    //목록 조회
    @GetMapping("/account")
    public List<Account> all(){
        return accountRepository.findAll();
    }
    // 단건 조회

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("illegal argument :" + id));
    }


}

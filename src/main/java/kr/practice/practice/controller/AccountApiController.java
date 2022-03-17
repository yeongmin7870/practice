package kr.practice.practice.controller;

import kr.practice.practice.Account.Account;
import kr.practice.practice.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class AccountApiController {


    // 생성자 주입으로 AccountRepository를 주입시켜준다.
    private final AccountRepository repository;

    AccountApiController(AccountRepository repository){
        this.repository = repository;
    }

    //전체 조회
    @GetMapping("/account")
    List<Account> all() {
        return repository.findAll();
    }

    @PostMapping("/account")
    Account newAccount(@RequestBody Account newAccount){
        return repository.save(newAccount);
    }


}

package kr.practice.practice.controller;

import kr.practice.practice.Account.Account;
import kr.practice.practice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountApiController {


    // 생성자 주입으로 AccountRepository를 주입시켜준다.
    private final AccountRepository accountRepository;

    @PostMapping("/account")
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
        Account saveAccount = accountRepository.save(account);
        return ResponseEntity.ok(saveAccount);
    }


}

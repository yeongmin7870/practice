package kr.practice.practice.controller;

import kr.practice.practice.Account.Account;
import kr.practice.practice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
        Account saveAccount = accountRepository.save(account);
        System.out.println("결과: "+account);
        return ResponseEntity.ok(saveAccount);
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

package kr.practice.practice.repository;

import kr.practice.practice.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Transactional
    void deleteAllById(Long id);
}

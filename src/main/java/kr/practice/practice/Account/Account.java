package kr.practice.practice.Account;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private Long AccountNUm;
    private String name;

    public Long getAccountNUm() {
        return AccountNUm;
    }

    public void setAccountNUm(Long accountNUm) {
        AccountNUm = accountNUm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package kr.practice.practice.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue
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

    @Override
    public String toString() {
        return "Account{" +
                "AccountNUm=" + AccountNUm +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(AccountNUm, account.AccountNUm) && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountNUm, name);
    }

    public Account() {
    }
}

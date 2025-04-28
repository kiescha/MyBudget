package budget.mypersonalbudget.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class BankEntity {
    @Id
    private long bankId;
    private String bankName;
    @OneToMany
    private List<UserEntity> user;
    @OneToMany
    private List<CardEntity> card;

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getBankId() {
        return bankId;
    }
}

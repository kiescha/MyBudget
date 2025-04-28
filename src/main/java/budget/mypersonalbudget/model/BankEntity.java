package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BankEntity {
    @Id
    private long bankId;
    private String bankName;

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getBankId() {
        return bankId;
    }
}

package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TransactionTypeEntity {
    @Id
    private long transactionTypeId;
    private String bankAccount;
    private double cash;
    private String otherBank;

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }
}

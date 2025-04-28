package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransactionEntity {
    private Long transactionId;
    private double income;
    private double expense;
    private double amount;
    private String date;
    private String description;
}

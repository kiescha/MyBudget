package budget.mypersonalbudget.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TransactionEntity {
    private long id;
    private double amount;
    private double income;
    private double expense;
    private String description;
    private LocalDateTime date;
}

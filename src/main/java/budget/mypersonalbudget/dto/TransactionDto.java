package budget.mypersonalbudget.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class TransactionDto {
    private double income;
    private double expense;
    private String category;
    private double amount;
    private String description;
}



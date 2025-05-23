package budget.mypersonalbudget.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private long id;
    private boolean income; //true=income, false=expense.
    private String category;
    private BigDecimal amount;
    private String description;
    private LocalDateTime date;
}



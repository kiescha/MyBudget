package budget.mypersonalbudget.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TransactionEntity {
    private long id;
    private boolean income;
    private String category;
    private BigDecimal amount;
    private String description;
    private LocalDateTime date;
}

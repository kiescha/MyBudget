package budget.mypersonalbudget.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
public class Transaction {
    private BigDecimal amount;
    private String description;
    private String category;
    private LocalDateTime date;
    private Boolean type;
}

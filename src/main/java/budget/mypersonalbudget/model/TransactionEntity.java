package budget.mypersonalbudget.model;

import budget.mypersonalbudget.core.domain.TransactionTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class TransactionEntity {
    private UUID id;
    private TransactionTypeEnum type;
    private String category;
    private BigDecimal amount;
    private String description;
    private LocalDateTime date;
}

package budget.mypersonalbudget.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class Transaction {
    private UUID id;
    private BigDecimal amount;
    private String description;
    private TransactionCategoryEnum category;
    private LocalDateTime date;
    private TransactionTypeEnum type;

    public UUID getId() {
        return id != null ? id : UUID.randomUUID();
    }
}

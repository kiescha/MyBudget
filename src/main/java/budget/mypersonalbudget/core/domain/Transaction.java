package budget.mypersonalbudget.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
public class Transaction {
    private UUID id;
    private BigDecimal amount;
    private String description;
    private TransactionCategoryEnum category;
    private LocalDate date;
    private TransactionTypeEnum type;

    public UUID getId() {
        return id != null ? id : UUID.randomUUID();
    }
}

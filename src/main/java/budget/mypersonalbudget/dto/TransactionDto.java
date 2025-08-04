package budget.mypersonalbudget.dto;

import budget.mypersonalbudget.core.domain.TransactionCategoryEnum;
import budget.mypersonalbudget.core.domain.TransactionTypeEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private UUID id;
    
    @NotNull(message = "Type is required")
    private TransactionTypeEnum type;
    
    private TransactionCategoryEnum category;
    
    @Positive(message = "Amount must be greater than zero")
    @NotNull(message = "Amount is required")
    private BigDecimal amount;
    
    private String description;
    
    @NotNull(message = "Date is required")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}



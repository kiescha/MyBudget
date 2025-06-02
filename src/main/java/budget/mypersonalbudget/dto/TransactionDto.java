package budget.mypersonalbudget.dto;

import budget.mypersonalbudget.core.domain.TransactionTypeEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private UUID id;
    private TransactionTypeEnum type;
    private String category;
    private BigDecimal amount;
    private String description;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private LocalDateTime date;
}



package budget.mypersonalbudget.model;

import budget.mypersonalbudget.core.domain.TransactionCategoryEnum;
import budget.mypersonalbudget.core.domain.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "transaction_id", nullable = false)
    private UUID transactionId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionTypeEnum type;
    
    @Enumerated(EnumType.STRING)
    private TransactionCategoryEnum category;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    private String description;
    
    private LocalDate date;
}

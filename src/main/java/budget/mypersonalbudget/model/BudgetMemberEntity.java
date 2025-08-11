package budget.mypersonalbudget.model;

import budget.mypersonalbudget.core.domain.BudgetRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "budget_member", uniqueConstraints = @UniqueConstraint(columnNames = {"budget_id", "user_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "budget_id", nullable = false)
    private Long budgetId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private BudgetRole role;
}



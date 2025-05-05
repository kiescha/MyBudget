package budget.mypersonalbudget.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "budget_client")
public class BudgetClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long budgetClientId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "budget_id" , nullable = false)
    private BudgetEntity budget;

    @Enumerated(EnumType.STRING)
    private ClientRoleEnum role;
}

package budget.mypersonalbudget.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank")
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bankId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CardEntity card;
}

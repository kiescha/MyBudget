package budget.mypersonalbudget.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank_account")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bankId;
    private String accountName;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private BankEntity bank;
}

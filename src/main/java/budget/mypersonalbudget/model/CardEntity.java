package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CardEntity {
    @Id
    private long cardId;
    private String cardName;
    private String cardType;
    @ManyToOne
    @JoinColumn(name = "bank_bank_id")
    private BankEntity bank;

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }
}

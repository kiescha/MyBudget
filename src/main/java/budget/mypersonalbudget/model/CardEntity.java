package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }
}

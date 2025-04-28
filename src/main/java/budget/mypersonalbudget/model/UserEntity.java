package budget.mypersonalbudget.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class UserEntity {
    @Id
    private long userId;
    private String nickName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<BudgetUserEntity> budgetUsers;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

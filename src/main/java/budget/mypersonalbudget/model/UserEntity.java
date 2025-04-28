package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEntity {
    @Id
    private long userId;
    private String nickName;
    private String email;
    private String password;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

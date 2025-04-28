package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CategoryEntity {
    @Id
    private long categoryId;
    private String food;
    private String rent;
    private String salary;
    private String other;

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}

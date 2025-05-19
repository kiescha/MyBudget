package budget.mypersonalbudget.dto;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionFormDto {
    private boolean income;
    private String category;
    private BigDecimal amount;
    private String description;
    private String date;

}

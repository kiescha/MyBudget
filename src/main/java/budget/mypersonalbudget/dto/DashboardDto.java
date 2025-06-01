package budget.mypersonalbudget.dto;

import budget.mypersonalbudget.core.domain.Transaction;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
@Builder

public class DashboardDto {
    private List<Transaction> transactionDtoList;
    BigDecimal balance;
}

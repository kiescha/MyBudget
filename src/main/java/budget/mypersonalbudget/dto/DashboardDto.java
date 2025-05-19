package budget.mypersonalbudget.dto;

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
    private List<TransactionDto> transactionDtoList;
    BigDecimal balance;
}

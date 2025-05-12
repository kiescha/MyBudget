package budget.mypersonalbudget.dto;

public record ClientDto(
        long id,
        String nickName,
        String email,
        String password) {
}

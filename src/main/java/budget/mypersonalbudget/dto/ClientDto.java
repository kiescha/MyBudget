package budget.mypersonalbudget.dto;

public record ClientDto(
        long userId,
        String nickName,
        String email,
        String password) {
}

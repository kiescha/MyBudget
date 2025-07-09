package budget.mypersonalbudget.user.dto;

public record RegisterRequest(
        String username,
        String password,
        String email
) {
} 
package budget.mypersonalbudget.user.services;
import budget.mypersonalbudget.user.model.UserEntity;
import budget.mypersonalbudget.user.reposiroty.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CurrentUserName {

    private final UserRepository userRepository;


    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) return null;
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails u) return u.getUsername();
        return auth.getName();
    }

    public Long getCurrentUserIdOrThrow() {
        String username = getCurrentUsername();
        if (username == null) throw new RuntimeException("Unauthenticated");
        return userRepository.findByName(username)
                .map(UserEntity::getId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

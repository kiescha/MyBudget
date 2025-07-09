package budget.mypersonalbudget.user.services;

import budget.mypersonalbudget.user.model.UserEntity;
import budget.mypersonalbudget.user.reposiroty.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(userEntity.getName())
                .password(userEntity.getPassword())
                .authorities("Role_" + userEntity.getRole().name())
                .disabled( !userEntity.isEnabled())
                .build();
    }


}

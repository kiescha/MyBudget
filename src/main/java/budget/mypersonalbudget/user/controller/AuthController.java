package budget.mypersonalbudget.user.controller;

import budget.mypersonalbudget.security.JwtUtils;
import budget.mypersonalbudget.user.dto.LoginRequest;
import budget.mypersonalbudget.user.dto.LoginResponse;
import budget.mypersonalbudget.user.dto.RegisterRequest;
import budget.mypersonalbudget.user.model.Role;
import budget.mypersonalbudget.user.model.UserEntity;
import budget.mypersonalbudget.user.reposiroty.UserRepository;
import budget.mypersonalbudget.user.services.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate user
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.username(), 
                    loginRequest.password()
                )
            );

            // Generate JWT token
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.username());
            String jwt = jwtUtils.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new LoginResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            // Check if user already exists
            if (userRepository.findByName(request.username()).isPresent()) {
                return ResponseEntity.badRequest().body("Username already exists");
            }

            // Create new user
            UserEntity newUser = UserEntity.builder()
                    .name(request.username())
                    .password(passwordEncoder.encode(request.password()))
                    .email(request.email())
                    .enabled(true)
                    .role(Role.USER)
                    .build();

            // Save user to database
            userRepository.save(newUser);

            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }
} 
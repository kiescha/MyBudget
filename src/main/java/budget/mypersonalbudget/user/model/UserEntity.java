package budget.mypersonalbudget.user.model;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@Entity
@Table(name = "user_entity")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

}

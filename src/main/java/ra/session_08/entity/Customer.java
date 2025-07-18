package ra.session_08.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;
    @Column(nullable = false, unique = true, length = 15)
    private String phone;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 50)
    private Integer numberOfPayments;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
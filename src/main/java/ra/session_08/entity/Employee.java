package ra.session_08.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullname;
    @Column(nullable = false, unique = true, length = 15)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 50)
    private String position;
    @Column(nullable = false)
    private Double salary;
}
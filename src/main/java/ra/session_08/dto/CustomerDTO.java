package ra.session_08.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private String fullName;
    private String phone;
    private String email;
    private Integer numberOfPayments;
    private boolean status;
    private LocalDateTime createdAt;
}
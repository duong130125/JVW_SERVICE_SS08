package ra.session_08.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class IngredientDTO {
    private String name;
    private Integer stock;
    private LocalDate expiry;
    private MultipartFile image;
}

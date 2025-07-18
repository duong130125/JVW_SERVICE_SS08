package ra.session_08.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session_08.dto.ApiResponse;
import ra.session_08.dto.IngredientDTO;
import ra.session_08.entity.Ingredient;
import ra.session_08.service.IngredientService;

import java.io.IOException;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Ingredient>> createIngredient(@ModelAttribute IngredientDTO dto) throws IOException {
        Ingredient created = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Tạo nguyên liệu thành công", created));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Ingredient>> updateIngredient(
            @PathVariable Long id,
            @ModelAttribute IngredientDTO dto
    ) throws IOException {
        Ingredient updated = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật nguyên liệu thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteIngredient(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Xóa nguyên liệu thành công", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllIngredients() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy danh sách thành công", service.findAll()));
    }
}

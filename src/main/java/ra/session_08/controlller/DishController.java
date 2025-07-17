package ra.session_08.controlller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session_08.dto.ApiResponse;
import ra.session_08.dto.DishDTO;
import ra.session_08.entity.Dish;
import ra.session_08.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Dish>> createDish(@ModelAttribute DishDTO dto) {
        Dish created = dishService.createDish(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Tạo món ăn thành công", created));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Dish>> updateDish(@PathVariable Long id, @ModelAttribute DishDTO dto) {
        Dish updated = dishService.updateDish(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật món ăn thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Xóa món ăn thành công", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Dish>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy danh sách thành công", dishService.getAll()));
    }
}

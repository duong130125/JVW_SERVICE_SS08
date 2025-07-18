package ra.session_08.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session_08.dto.ApiResponse;
import ra.session_08.dto.CustomerDTO;
import ra.session_08.entity.Customer;
import ra.session_08.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Customer>> create(@RequestBody CustomerDTO dto) {
        Customer created = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Thêm mới nhân viên thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        Customer updated = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật nhân viên thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Xóa nhân viên thành công", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Customer>>> findAll() {
        List<Customer> customers = service.findAll();
        return ResponseEntity.ok(new ApiResponse<>(true, "Hiển thị danh sách nhân viên", customers));
    }
}

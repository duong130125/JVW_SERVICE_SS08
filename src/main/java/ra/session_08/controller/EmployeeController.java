package ra.session_08.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session_08.dto.ApiResponse;
import ra.session_08.entity.Employee;
import ra.session_08.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> create(@RequestBody Employee employee) {
        Employee created = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Nhân viên được tạo thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> update(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updated = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(new ApiResponse<>(true, "Nhân viên được cập nhật thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Nhân viên đã được xóa thành công", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAll() {
        List<Employee> list = employeeService.getAllEmployees();
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã lấy được danh sách nhân viên", list));
    }
}
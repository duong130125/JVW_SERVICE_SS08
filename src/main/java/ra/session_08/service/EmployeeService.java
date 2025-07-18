package ra.session_08.service;

import org.springframework.stereotype.Service;
import ra.session_08.entity.Employee;
import ra.session_08.exception.NoResourceFoundException;
import ra.session_08.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedData) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoResourceFoundException("Nhân viên không tồn tại"));

        employee.setFullname(updatedData.getFullname());
        employee.setPhone(updatedData.getPhone());
        employee.setAddress(updatedData.getAddress());
        employee.setPosition(updatedData.getPosition());
        employee.setSalary(updatedData.getSalary());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new NoResourceFoundException("không tìm thấy nhân viên để xóa");
        }
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

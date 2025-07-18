package ra.session_08.service;

import org.springframework.stereotype.Service;
import ra.session_08.dto.CustomerDTO;
import ra.session_08.entity.Customer;
import ra.session_08.exception.NoResourceFoundException;
import ra.session_08.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(CustomerDTO dto) {
        Customer customer = Customer.builder()
                .fullName(dto.getFullName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .numberOfPayments(dto.getNumberOfPayments())
                .status(dto.isStatus())
                .createdAt(LocalDateTime.now())
                .build();
        return repository.save(customer);
    }

    public Customer update(Long id, CustomerDTO dto) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new NoResourceFoundException("Khách hàng không tồn tại với ID: " + id));

        customer.setFullName(dto.getFullName());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        customer.setNumberOfPayments(dto.getNumberOfPayments());
        customer.setStatus(dto.isStatus());

        return repository.save(customer);
    }

    public void delete(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new NoResourceFoundException("Không tìm thấy khách hàng với ID: " + id));
        customer.setStatus(false);
        repository.save(customer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}

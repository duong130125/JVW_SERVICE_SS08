package ra.session_08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_08.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
}

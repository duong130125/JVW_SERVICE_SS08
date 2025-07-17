package ra.session_08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_08.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
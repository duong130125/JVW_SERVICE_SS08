package ra.session_08.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.session_08.dto.IngredientDTO;
import ra.session_08.entity.Ingredient;
import ra.session_08.exception.NoResourceFoundException;
import ra.session_08.repository.IngredientRepository;

import java.io.IOException;
import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository repository;
    private final CloudinaryService cloudinaryService;

    public IngredientService(IngredientRepository repository, CloudinaryService cloudinaryService) {
        this.repository = repository;
        this.cloudinaryService = cloudinaryService;
    }

    public Ingredient create(IngredientDTO dto) {
        String imageUrl = cloudinaryService.uploadImage(dto.getImage());

        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());
        ingredient.setStock(dto.getStock());
        ingredient.setExpiry(dto.getExpiry());
        ingredient.setImage(imageUrl);

        return repository.save(ingredient);
    }

    public Ingredient update(Long id, IngredientDTO dto) {
        Ingredient ingredient = repository.findById(id)
                .orElseThrow(() -> new NoResourceFoundException("Nguyên liệu không tồn tại"));

        ingredient.setName(dto.getName());
        ingredient.setStock(dto.getStock());
        ingredient.setExpiry(dto.getExpiry());

        if (dto.getImage() != null && !dto.getImage().isEmpty()) {
            String newImageUrl = cloudinaryService.uploadImage(dto.getImage());
            ingredient.setImage(newImageUrl);
        }

        return repository.save(ingredient);
    }

    public void delete(Long id) {
        Ingredient existing = repository.findById(id)
                .orElseThrow(() -> new NoResourceFoundException("Ingredient not found"));
        repository.delete(existing);
    }

    public List<Ingredient> findAll() {
        return repository.findAll();
    }
}
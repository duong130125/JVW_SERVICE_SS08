package ra.session_08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session_08.dto.DishDTO;
import ra.session_08.entity.Dish;
import ra.session_08.exception.NoResourceFoundException;
import ra.session_08.repository.DishRepository;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;
    private final CloudinaryService cloudinaryService = new CloudinaryService();

    public Dish createDish(DishDTO dto) {
        String imageUrl = cloudinaryService.uploadImage(dto.getImage());

        Dish dish = new Dish();
        dish.setName(dto.getName());
        dish.setDescription(dto.getDescription());
        dish.setPrice(dto.getPrice());
        dish.setStatus(dto.getStatus());
        dish.setImage(imageUrl);

        return dishRepository.save(dish);
    }

    public Dish updateDish(Long id, DishDTO dto) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new NoResourceFoundException("Món ăn không tồn tại"));

        dish.setName(dto.getName());
        dish.setDescription(dto.getDescription());
        dish.setPrice(dto.getPrice());
        dish.setStatus(dto.getStatus());

        if (dto.getImage() != null && !dto.getImage().isEmpty()) {
            String newImageUrl = cloudinaryService.uploadImage(dto.getImage());
            dish.setImage(newImageUrl);
        }

        return dishRepository.save(dish);
    }

    public void deleteDish(Long id) {
        if (!dishRepository.existsById(id)) {
            throw new NoResourceFoundException("Không tìm thấy món ăn để xóa");
        }
        dishRepository.deleteById(id);
    }

    public List<Dish> getAll() {
        return dishRepository.findAll();
    }
}

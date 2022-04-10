package fr.coucou.zoomup.repository;

import fr.coucou.zoomup.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

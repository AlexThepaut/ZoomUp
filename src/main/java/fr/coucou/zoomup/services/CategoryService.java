package fr.coucou.zoomup.services;

import fr.coucou.zoomup.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
}

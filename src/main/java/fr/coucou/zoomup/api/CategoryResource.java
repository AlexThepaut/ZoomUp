package fr.coucou.zoomup.api;

import fr.coucou.zoomup.domain.DTO.CategoryDto;
import fr.coucou.zoomup.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/category")
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

}

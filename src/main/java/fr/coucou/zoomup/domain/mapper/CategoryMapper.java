package fr.coucou.zoomup.domain.mapper;


import fr.coucou.zoomup.domain.Category;
import fr.coucou.zoomup.domain.DTO.CategoryDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDto toDto(Category user);
    Category toEntity(CategoryDto user);
}

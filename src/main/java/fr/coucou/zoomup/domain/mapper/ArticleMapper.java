package fr.coucou.zoomup.domain.mapper;

import fr.coucou.zoomup.domain.Article;
import fr.coucou.zoomup.domain.DTO.ArticleDto;
import org.mapstruct.Mapper;

@Mapper
public interface ArticleMapper {
    ArticleDto toDto(Article article);
    Article toEntity(ArticleDto articleDto);
}

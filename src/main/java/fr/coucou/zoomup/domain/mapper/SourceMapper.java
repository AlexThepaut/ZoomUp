package fr.coucou.zoomup.domain.mapper;

import fr.coucou.zoomup.domain.DTO.SourceDto;
import fr.coucou.zoomup.domain.Source;
import org.mapstruct.Mapper;

@Mapper
public interface SourceMapper {
    SourceDto toDto(Source source);
    Source toEntity(SourceDto sourceDto);
}

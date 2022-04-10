package fr.coucou.zoomup.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private List<Long> sources;
}

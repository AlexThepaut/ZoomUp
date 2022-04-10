package fr.coucou.zoomup.domain.DTO;

import fr.coucou.zoomup.domain.Category;

import java.util.List;

public class SourceDto {
    private Long id;
    private String name;
    private String url;
    private Category category;
    private List<Long> articles;
}

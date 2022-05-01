package fr.coucou.zoomup.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String url;

    @ManyToOne
    private Category category;

    @OneToMany(targetEntity= Article.class, fetch=FetchType.LAZY)
    private List<Article> articles;
}

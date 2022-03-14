package fr.coucou.feederz.api;

import fr.coucou.feederz.domain.Article;
import fr.coucou.feederz.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ArticleResource {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/article")
    public List<Article> getArticle() {
        log.debug("Get all article");
        return articleRepository.findAll();
    }

    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }
}

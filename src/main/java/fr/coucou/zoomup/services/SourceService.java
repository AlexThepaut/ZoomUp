package fr.coucou.zoomup.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.coucou.zoomup.domain.Article;
import fr.coucou.zoomup.domain.DTO.morss.Rss;
import fr.coucou.zoomup.domain.Source;
import fr.coucou.zoomup.repository.ArticleRepository;
import fr.coucou.zoomup.repository.SourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Service
public class SourceService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private SourceRepository sourceRepository;

    public Rss getRssFeed() {
        Source feed = new Source();
        feed.setUrl("http://www.developpez.com/index/rss");
        StringBuilder requestMorss = new StringBuilder("http://localhost:8000/");
        requestMorss.append(feed.getUrl().split("://")[1]);
        RestTemplate rest = new RestTemplate();
        String resp = rest.getForObject(requestMorss.toString(), String.class);
        Rss value = new Rss();
        try {
            XmlMapper xmlMapper = new XmlMapper();
            value = xmlMapper.readValue(resp, Rss.class);
        } catch (IOException e) {
            log.error(e.toString());
        }
        return value;
    }

    public Article getArticleResume(Rss feed) throws JSONException {
        /*String url = "https://api.deepai.org/api/summarization";

        RestTemplate requestAi = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", "quickstart-QUdJIGlzIGNvbWluZy4uLi4K");

        String resp = requestAi.postForEntity(url, feed.getChannel().getItem().get(0).getEncoded(), String.class, headers).getBody();

        Article finalArticle = new Article();
        finalArticle.setTitle(feed.getChannel().getItem().get(0).getTitle());
        finalArticle.setResume(resp);
        articleRepository.save(finalArticle);*/
        String text = feed.getChannel().getItem().get(0).getEncoded().replaceAll("\\<.*?\\>", "").trim().replaceAll("\n", "");
        log.info(text);
        String command = "curl \\ -F 'text=\"" + text + "\"' \\ -H 'api-key:143c6986-9b94-49c0-b1b5-113f1ca99f6f' \\ https://api.deepai.org/api/summarization ";
        log.info("Command to run {}", command);
        try {
            Process process = Runtime.getRuntime().exec(command);
            printProcessOutput(process);
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void printProcessOutput(Process process) throws IOException {
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(process.getErrorStream()));

        log.info("Here is the standard output of the command:");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            log.info(s);
        }

        log.info("Here is the standard error of the command (if any):");
        while ((s = stdError.readLine()) != null) {
            log.info(s);
        }
    }
}

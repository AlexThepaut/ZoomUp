package fr.coucou.zoomup.api;

import fr.coucou.zoomup.services.SourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/source")
public class SourceResource {
    @Autowired
    private SourceService sourceService;

    @GetMapping("/feeds")
    public String runFeeds() {
        /*try {
            return rssFluxService.getArticleResume(rssFluxService.getRssFeed());
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        return "Hello";
    }
}

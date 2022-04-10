package fr.coucou.zoomup.domain.DTO.morss;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Channel {
    public String link;
    public String title;
    public String description;
    public Date pubDate;
    public Date lastBuildDate;
    public String copyright;
    public Image image;
    public String generator;
    public String language;
    public String docs;
    @JacksonXmlElementWrapper(useWrapping=false)
    public List<Item> item;
}

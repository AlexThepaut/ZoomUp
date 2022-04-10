package fr.coucou.zoomup.domain.DTO.morss;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    public String title;
    public String link;
    public String guid;
    public String description;
    public Date pubDate;
    public String comments;
    public Enclosure enclosure;
    public String encoded;
}

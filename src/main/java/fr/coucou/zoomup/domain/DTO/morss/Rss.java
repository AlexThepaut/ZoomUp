package fr.coucou.zoomup.domain.DTO.morss;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rss {
    @JacksonXmlElementWrapper(useWrapping=false)
    public Channel channel;
    public String content;
    public String atom;
    public double version;
}

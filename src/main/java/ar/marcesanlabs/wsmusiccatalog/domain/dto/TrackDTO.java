package ar.marcesanlabs.wsmusiccatalog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDTO {

    private Long trackId;
    private String name;
    private Date releaseDate;
    private String uri;
    private String genres;
    private Integer duration;
    private Integer trackNumber;
    private Integer popularity;
}

package ar.marcesanlabs.wsmusiccatalog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDTO {

    private Long trackId;
    private String name;
    private LocalDate releaseDate;
    private String uri;
    private String genres;
    private Integer duration;
    private Integer trackNumber;
    private Integer popularity;
}

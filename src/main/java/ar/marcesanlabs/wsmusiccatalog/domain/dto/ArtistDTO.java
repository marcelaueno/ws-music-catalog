package ar.marcesanlabs.wsmusiccatalog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO {

    private Long artistId;
    private String name;
    private String description;
    private LocalDate dateFounded;
    private String imageUrl;
    private String genres;
    private Integer popularity;
    private Integer follower;
    private String uri;

}

package ar.marcesanlabs.wsmusiccatalog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

    private Long albumId;
    private String name;
    private Date date;
    private String type;
    private String imageUrl;
    private Integer popularity;
    private String uri;
    private String urlTracks;
    private List<TrackDTO> tracks;
}

package ar.marcesanlabs.wsmusiccatalog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistaAlbumsTracksDTO {
    private Long artistId;
    private String name;

    private List<AlbumDTO> albumDTOS;

}

package ar.marcesanlabs.wsmusiccatalog.domain.request;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.AlbumDTO;
import ar.marcesanlabs.wsmusiccatalog.domain.dto.ArtistDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullDataArtistRequest {
    private ArtistDTO artist;
    private List<AlbumDTO> albums;
}

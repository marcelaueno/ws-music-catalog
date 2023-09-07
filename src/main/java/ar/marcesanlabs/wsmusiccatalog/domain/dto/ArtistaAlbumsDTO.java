package ar.marcesanlabs.wsmusiccatalog.domain.dto;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Album;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistaAlbumsDTO {

    private Long artistId;
    private String name;
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Album album;
}

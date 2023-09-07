package ar.marcesanlabs.wsmusiccatalog.domain.dto;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Track;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistaCancionesDTO {

    private Long artistId;
    private String name;
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Track track;

}

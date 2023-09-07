package ar.marcesanlabs.wsmusiccatalog.infrastructure.business;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.AlbumDTO;
import ar.marcesanlabs.wsmusiccatalog.domain.dto.ArtistDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ICustomerService {

    //si le paso a createFullData parametros DTO no puedo pasarle request ni response
    Boolean createFullData(ArtistDTO artistDTO, List<AlbumDTO> albums);
}

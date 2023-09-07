package ar.marcesanlabs.wsmusiccatalog.infrastructure.business.imp;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.AlbumDTO;
import ar.marcesanlabs.wsmusiccatalog.domain.dto.ArtistDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public Boolean createFullData(ArtistDTO artistDTO, List<AlbumDTO> albums) {
        return null;
    }
}

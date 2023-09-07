package ar.marcesanlabs.wsmusiccatalog.controller;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.ArtistDTO;
import ar.marcesanlabs.wsmusiccatalog.domain.request.FullDataArtistRequest;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICustomerService;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @RequestMapping(value = "/fullDataArtist", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createFullArtist(@RequestBody FullDataArtistRequest data) {

        if (data.getArtist() == null) {
            return  ResponseEntity.badRequest().build();
        }

        Boolean resultado = service.createFullData(data.getArtist(),data.getAlbums());
        if (resultado) {
            return ResponseEntity.status(HttpStatus.CREATED.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE.value()).build();
    }
}



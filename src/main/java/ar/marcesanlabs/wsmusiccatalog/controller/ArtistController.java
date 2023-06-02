package ar.marcesanlabs.wsmusiccatalog.controller;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICrudService;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private ICrudService<Artist, Long> service;

    @RequestMapping(value = "/artist/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Artist> getByKey(@PathVariable Long id) {

        Artist data = service.getByKey(id);
        if (data != null && data.getArtistId() != null) {
            return  ResponseEntity.status(HttpStatus.OK.value()).body(data);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(data);
        }
    }

    //@GetMapping(value = "/artist")
    @RequestMapping(value = "/artist", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Artist>> getAll() {

        List<Artist> lista = service.getAll();
        if (lista != null && lista.size() > 0) {
            return  ResponseEntity.status(HttpStatus.OK.value()).body(lista);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(lista);
        }
    }

    @RequestMapping(value = "/artist", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity insert(@RequestBody Artist data) {

        if (data.getName() == null) {
            return  ResponseEntity.badRequest().build();
        }

        Boolean resultado = service.insert(data);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.CREATED.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE.value()).build();
    }

    @RequestMapping(value = "/artist", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity update(@RequestBody Artist data) {

        if (data.getArtistId() == null || data.getName() == null) {
            return  ResponseEntity.badRequest().build();
        }

        Boolean resultado = service.update(data);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.ACCEPTED.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED.value()).build();
    }

    @RequestMapping(value = "/artist/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Long id) {

        if (id == null || id < 1) {
            return  ResponseEntity.badRequest().build();
        }

        Boolean resultado = service.delete(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED.value()).build();
    }
}

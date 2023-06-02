package ar.marcesanlabs.wsmusiccatalog.controller;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICrudService;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    private ICrudService<Album, Long> service;

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Album> getByKey(@PathVariable Long id) {

        Album data = service.getByKey(id);
        if (data != null && data.getAlbumId() != null) {
            return  ResponseEntity.status(HttpStatus.OK.value()).body(data);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(data);
        }
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Album>> getAll() {

        List<Album> lista = service.getAll();
        if (lista != null && lista.size() > 0) {
            return  ResponseEntity.status(HttpStatus.OK.value()).body(lista);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(lista);
        }
    }

    @RequestMapping(value = "/album", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity insert(@RequestBody Album data) {

        if (data.getName() == null) {
            return  ResponseEntity.badRequest().build();
        }

        Boolean resultado = service.insert(data);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.CREATED.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE.value()).build();
    }

    @RequestMapping(value = "/album", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity update(@RequestBody Album data) {

        if (data.getAlbumId() == null || data.getName() == null) {
            return  ResponseEntity.badRequest().build();
        }

        Boolean resultado = service.update(data);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.ACCEPTED.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED.value()).build();
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.DELETE, produces = "application/json")
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

package ar.marcesanlabs.wsmusiccatalog.controller;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICrudService;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController {

    @Autowired
    private ICrudService<Track, Long> service;

    @RequestMapping(value = "/track/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Track> getByKey(@PathVariable Long id) {

        Track data = service.getByKey(id);
        if (data != null && data.getTrackId() != null) {
            return  ResponseEntity.status(HttpStatus.OK.value()).body(data);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(data);
        }
    }

    @RequestMapping(value = "/track", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Track>> getAll() {

        List<Track> lista = service.getAll();
        if (lista != null && lista.size() > 0) {
            return  ResponseEntity.status(HttpStatus.OK.value()).body(lista);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(lista);
        }
    }

    @RequestMapping(value = "/track", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity insert(@RequestBody Track data) {

        if (data.getName() == null) {
            return  ResponseEntity.badRequest().build();
        }
        Boolean resultado = service.insert(data);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.CREATED.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE.value()).build();
    }

    @RequestMapping(value = "/track", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity update(@RequestBody Track data) {

        if (data.getTrackId() == null || data.getName() == null) {
            return  ResponseEntity.badRequest().build();
        }

        Boolean resultado = service.update(data);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.ACCEPTED.value()).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED.value()).build();
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.DELETE, produces = "application/json")
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

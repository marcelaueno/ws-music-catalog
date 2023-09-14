package ar.marcesanlabs.test.wsmusiccatalog.infrastructure.mapper;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.TrackDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Track;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.mapper.TrackMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackMapperTest {

    //clase a probar (instanciar)
    TrackMapper mapper = new TrackMapper();

    @Test
    void transformTrackToDtoTest() {

        //crear data de prueba
        Track track = new Track();
        track.setTrackId(1L);
        track.setName("Cerati");
        LocalDate localDate = LocalDate.parse("2023-10-10");
        track.setReleaseDate(localDate);
        track.setUri("http://artista1.com");
        track.setGenres("Rock");
        track.setDuration(1);
        track.setTrackNumber(1);
        track.setPopularity(10);

        TrackDTO trackDTO = mapper.mapToTrackDTO(track);
        assertEquals(trackDTO.getName(), track.getName());
        assertEquals(trackDTO.getReleaseDate(), track.getReleaseDate());
        assertEquals(trackDTO.getUri(), track.getUri());
        assertEquals(trackDTO.getGenres(), track.getGenres());
        assertEquals(trackDTO.getDuration(), track.getDuration());
        assertEquals(trackDTO.getTrackNumber(), track.getTrackNumber());
        assertEquals(trackDTO.getPopularity(), track.getPopularity());
    }

    @Test
    void transformDtoToTrackTest() {

        //crear data de prueba
        TrackDTO trackDTO = new TrackDTO();
        trackDTO.setTrackId(1L);
        trackDTO.setName("Cerati");
        LocalDate localDate = LocalDate.parse("2023-10-10");
        trackDTO.setReleaseDate(localDate);
        trackDTO.setUri("http://artista1.com");
        trackDTO.setGenres("Rock");
        trackDTO.setDuration(1);
        trackDTO.setTrackNumber(1);
        trackDTO.setPopularity(10);

        Track track = mapper.mapToTrack(trackDTO);
        assertEquals(track.getName(), trackDTO.getName());
        assertEquals(track.getReleaseDate(), trackDTO.getReleaseDate());
        assertEquals(track.getUri(), trackDTO.getUri());
        assertEquals(track.getGenres(), trackDTO.getGenres());
        assertEquals(track.getDuration(), trackDTO.getDuration());
        assertEquals(track.getTrackNumber(), trackDTO.getTrackNumber());
        assertEquals(track.getPopularity(), trackDTO.getPopularity());
    }
}

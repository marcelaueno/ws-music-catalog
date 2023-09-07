package ar.marcesanlabs.test.wsmusiccatalog.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import ar.marcesanlabs.wsmusiccatalog.domain.dto.ArtistDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.mapper.ArtistMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class ArtistMapperTest {

    //clase a probar (instanciar)
    ArtistMapper mapper = new ArtistMapper();

    @Test
    void transformArtistToDtoTest() {

        //crear data de prueba
        Artist artist = new Artist();
        artist.setArtistId(1L);
        artist.setName("Cerati");
        artist.setUri("http://artista1.com");
        artist.setFollower(23);
        artist.setPopularity(10);
        artist.setGenres("Rock");
        artist.setImageUrl("http://artista1.com");
        LocalDate localDate = LocalDate.parse("2023-10-10");
        //tengo que crear el objeto date
        artist.setDateFounded(localDate);
        artist.setDescription("Cantante Solista");

        ArtistDTO artistDTO = mapper.mapToArtistDTO(artist);
        assertEquals(artist.getName(), artistDTO.getName());
        assertEquals(artist.getUri(), artistDTO.getUri());
        assertEquals(artist.getFollower(), artistDTO.getFollower());
        assertEquals(artist.getPopularity(), artistDTO.getPopularity());
        assertEquals(artist.getGenres(), artistDTO.getGenres());
        assertEquals(artist.getImageUrl(), artistDTO.getImageUrl());
        assertEquals(artist.getDateFounded(), artistDTO.getDateFounded());
        assertEquals(artist.getDescription(), artistDTO.getDescription());
    }

    @Test
    void transformDtoToArtistTest() {

        //crear data de prueba
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setArtistId(1L);
        artistDTO.setName("Cerati");
        artistDTO.setDescription("Cantante Solista");
        LocalDate localDate = LocalDate.parse("2023-10-10");
        artistDTO.setDateFounded(localDate);
        artistDTO.setImageUrl("http://artista1.com");
        artistDTO.setGenres("Rock");
        artistDTO.setPopularity(10);
        artistDTO.setFollower(23);
        artistDTO.setUri("http://artista1.com");

        Artist artist = mapper.mapToArtist(artistDTO);
        assertEquals(artistDTO.getName(), artist.getName());
        assertEquals(artistDTO.getUri(), artist.getUri());
        assertEquals(artistDTO.getFollower(), artist.getFollower());
        assertEquals(artistDTO.getPopularity(), artist.getPopularity());
        assertEquals(artistDTO.getGenres(), artist.getGenres());
        assertEquals(artistDTO.getImageUrl(), artist.getImageUrl());
        assertEquals(artistDTO.getDateFounded(), artist.getDateFounded());
        assertEquals(artistDTO.getDescription(), artist.getDescription());
    }
}

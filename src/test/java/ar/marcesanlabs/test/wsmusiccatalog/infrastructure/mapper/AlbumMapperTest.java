package ar.marcesanlabs.test.wsmusiccatalog.infrastructure.mapper;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.AlbumDTO;
import ar.marcesanlabs.wsmusiccatalog.domain.dto.TrackDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Album;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.mapper.AlbumMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumMapperTest {

    //clase a probar (instanciar)
    AlbumMapper mapper = new AlbumMapper();

    @Test
    void transformAlbumToDtoTest() {

        //crear data de prueba
        Album album = new Album();
        album.setAlbumId(1L);
        album.setName("Bocanada");
        LocalDate localDate = LocalDate.parse("2023-10-10");
        album.setDate(localDate);
        album.setType("rock");
        album.setTotalTracks(10);
        album.setImageUrl("http://artista1.com");
        album.setPopularity(10);
        album.setUri("http://artista1.com");
        album.setUrlTracks("http://artista1.com");

        AlbumDTO albumDTO = mapper.mapToAlbumDTO(album);
        assertEquals(album.getName(), albumDTO.getName());
        assertEquals(album.getDate(), albumDTO.getDate());
        assertEquals(album.getType(), albumDTO.getType());
        //dto.gettrack me trae listado de canciones el otro trae int.
        //assertEquals(album.getTotalTracks(), albumDTO.getTracks());
        assertEquals(album.getImageUrl(), albumDTO.getImageUrl());
        assertEquals(album.getPopularity(), albumDTO.getPopularity());
        assertEquals(album.getUri(), albumDTO.getUri());
        assertEquals(album.getUrlTracks(), albumDTO.getUrlTracks());

    }

    @Test
    void transformDtoToAlbumTest() {

        //crear data de prueba
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setAlbumId(1L);
        albumDTO.setName("Bocanada");
        LocalDate localDate = LocalDate.parse("2023-10-10");
        albumDTO.setDate(localDate);
        albumDTO.setType("rock");
        albumDTO.setImageUrl("http://artista1.com");
        albumDTO.setPopularity(10);
        albumDTO.setUri("http://artista1.com");
        albumDTO.setUrlTracks("http://artista1.com");
        List<TrackDTO> tracks = new ArrayList<>();
        albumDTO.setTracks(tracks);

        // album tiene el total Int, pero el Dto tiene listado.
        Album album = mapper.mapToAlbum(albumDTO);
        assertEquals(albumDTO.getName(), album.getName());
        assertEquals(albumDTO.getDate(), album.getDate());
        assertEquals(albumDTO.getType(), album.getType());
        assertEquals(albumDTO.getImageUrl(), album.getImageUrl());
        assertEquals(albumDTO.getPopularity(), album.getPopularity());
        assertEquals(albumDTO.getUri(), album.getUri());
        assertEquals(albumDTO.getUrlTracks(), album.getUrlTracks());
        assertEquals(albumDTO.getTracks().size(), album.getTotalTracks());
    }
}

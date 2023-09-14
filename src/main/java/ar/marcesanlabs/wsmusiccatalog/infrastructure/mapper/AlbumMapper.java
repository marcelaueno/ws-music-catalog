package ar.marcesanlabs.wsmusiccatalog.infrastructure.mapper;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.AlbumDTO;
import ar.marcesanlabs.wsmusiccatalog.domain.dto.TrackDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Album;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;

import java.util.List;

public class AlbumMapper {

    public Album mapToAlbum(AlbumDTO albumDTO) {
        Album album = new Album();
        album.setAlbumId(albumDTO.getAlbumId());
        album.setName(albumDTO.getName());
        album.setDate(albumDTO.getDate());
        album.setType(albumDTO.getType());
        album.setTotalTracks(albumDTO.getTracks().size());
        album.setImageUrl(albumDTO.getImageUrl());
        album.setPopularity(albumDTO.getPopularity());
        album.setUri(albumDTO.getUri());
        album.setUrlTracks(albumDTO.getUrlTracks());
        return album;
    }
    //el artista se pasa fuera del mapper
    public Album mapToAlbum(AlbumDTO albumDTO, Artist artist) {
        Album album = mapToAlbum(albumDTO);
        album.setArtist(artist); // artista completo recibe
        return album;
    }

    public AlbumDTO mapToAlbumDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setAlbumId(album.getAlbumId());
        albumDTO.setName(album.getName());
        albumDTO.setDate(album.getDate());
        albumDTO.setType(album.getType());
        albumDTO.setImageUrl(album.getImageUrl());
        albumDTO.setPopularity(album.getPopularity());
        albumDTO.setUri(album.getUri());
        albumDTO.setUrlTracks(album.getUrlTracks());
        return albumDTO;
    }
    // los track se pasan fuera del mapper
    public AlbumDTO mapToAlbumDTO(Album album, List<TrackDTO> tracks) {
        AlbumDTO albumDTO = mapToAlbumDTO(album);
        albumDTO.setTracks(tracks);
        return albumDTO;
    }

    //sobrecarga es el mismo metodo pero recibe mas parametros.


}

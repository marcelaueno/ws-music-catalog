package ar.marcesanlabs.wsmusiccatalog.infrastructure.mapper;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.ArtistDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;

public class ArtistMapper {

    public Artist mapToArtist(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        artist.setArtistId(artistDTO.getArtistId());
        artist.setName(artistDTO.getName());
        artist.setDescription(artistDTO.getDescription());
        artist.setDateFounded(artistDTO.getDateFounded());
        artist.setImageUrl(artistDTO.getImageUrl());
        artist.setGenres(artistDTO.getGenres());
        artist.setPopularity(artistDTO.getPopularity());
        artist.setFollower(artistDTO.getFollower());
        artist.setUri(artistDTO.getUri());
        return artist;
    }

    public ArtistDTO mapToArtistDTO(Artist artist) {
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setArtistId(artist.getArtistId());
        artistDTO.setName(artist.getName());
        artistDTO.setDescription(artist.getDescription());
        artistDTO.setDateFounded(artist.getDateFounded());
        artistDTO.setImageUrl(artist.getImageUrl());
        artistDTO.setGenres(artist.getGenres());
        artistDTO.setPopularity(artist.getPopularity());
        artistDTO.setFollower(artist.getFollower());
        artistDTO.setUri(artist.getUri());
        return artistDTO;
    }




}

package ar.marcesanlabs.wsmusiccatalog.infrastructure.mapper;

import ar.marcesanlabs.wsmusiccatalog.domain.dto.TrackDTO;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Album;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Track;

public class TrackMapper {

    public static Track mapToTrack(TrackDTO trackDTO) {
        Track track = new Track();
        track.setTrackId(trackDTO.getTrackId());
        track.setName(trackDTO.getName());
        track.setReleaseDate(trackDTO.getReleaseDate());
        track.setUri(trackDTO.getUri());
        track.setGenres(trackDTO.getGenres());
        track.setDuration(trackDTO.getDuration());
        track.setTrackNumber(trackDTO.getTrackNumber());
        track.setPopularity(trackDTO.getPopularity());
        return track;

        // se pasa por fuera del mapper album y artista
    }

    public static Track mapToTrack(TrackDTO trackDTO, Artist artist, Album album) {
        Track track = mapToTrack(trackDTO);
        track.setArtist(artist);
        track.setAlbum(album);
        return track;

        // se pasa por fuera del mapper album y artista
    }
    public static TrackDTO mapToTrackDTO(Track track) {
        TrackDTO trackDTO = new TrackDTO();
        trackDTO.setTrackId(track.getTrackId());
        trackDTO.setName(track.getName());
        trackDTO.setReleaseDate(track.getReleaseDate());
        trackDTO.setUri(track.getUri());
        trackDTO.setGenres(track.getGenres());
        trackDTO.setDuration(track.getDuration());
        trackDTO.setTrackNumber(track.getTrackNumber());
        trackDTO.setPopularity(track.getPopularity());
        return trackDTO;
    }

    /*public static TrackDTO mapToTrackDTO(Track track, Artist artist, Album album) {
        TrackDTO trackDTO = mapToTrackDTO(track);
        return trackDTO;
    }
    no tiene artista ni album en els DTO, es necesario hacer la recarga?
    */



}

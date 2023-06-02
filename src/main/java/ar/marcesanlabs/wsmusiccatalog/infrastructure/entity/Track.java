package ar.marcesanlabs.wsmusiccatalog.infrastructure.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "track")
public class Track {

    @Column(name = "track_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;

    @Column(name = "name")
    private String name;

    // muchos tracks hay un albun
    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "uri")
    private String uri;

    @Column(name = "genres")
    private String genres;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "track_number")
    private Integer trackNumber;

    @Column(name = "popularity")
    private Integer popularity;

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Date getReleaseDate() { return releaseDate; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Artist getArtist() { return artist; }

    public void setArtist(Artist artist) { this.artist = artist; }
}

package ar.marcesanlabs.wsmusiccatalog.infrastructure.repository;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackRepository extends JpaRepository<Track, Long> {
}

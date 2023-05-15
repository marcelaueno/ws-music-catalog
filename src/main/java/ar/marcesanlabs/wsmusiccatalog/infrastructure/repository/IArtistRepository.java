package ar.marcesanlabs.wsmusiccatalog.infrastructure.repository;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, Long> {
}

package ar.marcesanlabs.wsmusiccatalog.infrastructure.repository;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Long> {

}

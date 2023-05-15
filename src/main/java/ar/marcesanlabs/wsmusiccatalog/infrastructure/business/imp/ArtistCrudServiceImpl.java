package ar.marcesanlabs.wsmusiccatalog.infrastructure.business.imp;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICrudService;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Artist;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistCrudServiceImpl implements ICrudService<Artist, Long> {

    @Autowired
    private IArtistRepository repository;

    @Override
    public Artist getByKey(Long key) {

        Optional<Artist> dato = repository.findById(key);
        if (dato.isPresent()) {
            return dato.get();
        }
        return null;
    }

    @Override
    public List<Artist> getAll() {
        return  repository.findAll();
    }

    @Override
    public Boolean insert(Artist data) {
        Artist artist = repository.save(data);
        if (artist == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean update(Artist data) {
        if (repository.existsById(data.getArtistId())) {
            Artist artist = repository.save(data);
            if (artist == null) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean delete(Long key) {

        if (repository.existsById(key)) {
            repository.deleteById(key);
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
    }
}

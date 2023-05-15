package ar.marcesanlabs.wsmusiccatalog.infrastructure.business.imp;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICrudService;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Album;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumCrudServiceImpl implements ICrudService<Album, Long> {

    @Autowired
    private IAlbumRepository repository;

    @Override
    public Album getByKey(Long key) {

        Optional<Album> dato = repository.findById(key);
        if (dato.isPresent()) {
            return dato.get();
        }
        return null;
    }

    @Override
    public List<Album> getAll() {
        return  repository.findAll();
    }

    @Override
    public Boolean insert(Album data) {
        Album album = repository.save(data);
        if (album == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean update(Album data) {

        if (repository.existsById(data.getAlbumId())) {
            Album album = repository.save(data);
            if (album == null) {
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

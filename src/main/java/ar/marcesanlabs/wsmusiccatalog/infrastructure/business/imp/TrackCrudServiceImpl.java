package ar.marcesanlabs.wsmusiccatalog.infrastructure.business.imp;

import ar.marcesanlabs.wsmusiccatalog.infrastructure.business.ICrudService;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.entity.Track;
import ar.marcesanlabs.wsmusiccatalog.infrastructure.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackCrudServiceImpl implements ICrudService<Track, Long> {

    @Autowired
    private ITrackRepository repository;

    @Override
    public Track getByKey(Long key) {

        Optional<Track> dato = repository.findById(key);
        if (dato.isPresent()) {
            return dato.get();
        }
        return null;
    }

    @Override
    public List<Track> getAll() {
        return  repository.findAll();
    }

    @Override
    public Boolean insert(Track data) {

        Track track = repository.save(data);
        if (track == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean update(Track data) {

        if (repository.existsById(data.getTrackId())) {
            Track track = repository.save(data);
            if (track == null) {
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
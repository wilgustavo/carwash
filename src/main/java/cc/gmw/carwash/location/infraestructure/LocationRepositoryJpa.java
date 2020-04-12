package cc.gmw.carwash.location.infraestructure;

import cc.gmw.carwash.location.model.Location;
import cc.gmw.carwash.location.model.LocationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class LocationRepositoryJpa implements LocationRepository {

    private final EntityManager entityManager;

    public LocationRepositoryJpa(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Location location) {
        entityManager.persist(location);
        entityManager.flush();
    }

}

package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@SpringBootTest
class LocationRepositoryJpaTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    void deberiaGuardar() {
        LocationId id = new LocationId(UUID.randomUUID());
        LocationName name = new LocationName(StringMother.random(100));
        LocationAddress address = LocationAddressMother.random();
        Location location = new Location(id, name, address);
        locationRepository.save(location);
    }
}
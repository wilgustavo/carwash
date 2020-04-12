package cc.gmw.carwash.location.application.create;

import cc.gmw.carwash.location.model.*;
import cc.gmw.carwash.shared.model.Service;
import cc.gmw.carwash.shared.model.event.EventBus;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LocationCreator {
    private final LocationRepository locationRepository;
    private final EventBus eventBus;

    @Transactional
    public void create(final LocationId id, final LocationName name, final LocationAddress address) {
        Location location = Location.create(id, name, address);
        locationRepository.save(location);
        eventBus.publish(location.pullDomainEvents());
    }
}

package cc.gmw.carwash.location.application.create;

import cc.gmw.carwash.location.model.*;
import cc.gmw.carwash.shared.model.event.DomainEvent;
import cc.gmw.carwash.shared.model.event.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class CreateLocationCommandHandlerShould {

    private LocationRepository locationRepository;
    private EventBus eventBus;
    private CreateLocationCommandHandler handler;

    @BeforeEach
    void init() {
        locationRepository = mock(LocationRepository.class);
        eventBus = mock(EventBus.class);
        handler = new CreateLocationCommandHandler(new LocationCreator(locationRepository, eventBus));
    }

    @Test
    void createLocation() {
        CreateLocationCommand command = CreateLocationCommandMother.random();
        Location location = LocationMother.fromCreateCommand(command);
        LocationCreateEvent event = LocationCreateEventMother.fromLocation(location);

        whenHandleisCalled(command);

        shouldHaveSaved(location);
        shouldHavePublished(event);
    }

    private void whenHandleisCalled(CreateLocationCommand command) {
        doNothing().when(locationRepository).save(isA(Location.class));
        doNothing().when(eventBus).publish(anyList());
        handler.handle(command);
    }

    private void shouldHaveSaved(Location location) {
        verify(locationRepository, times(1)).save(location);
    }

    private void shouldHavePublished(DomainEvent event) {
        verify(eventBus, only()).publish(Collections.singletonList(event));
    }

}


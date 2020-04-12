package cc.gmw.carwash.shared.infrastructure.event;

import cc.gmw.carwash.shared.model.event.DomainEvent;
import cc.gmw.carwash.shared.model.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        publisher.publishEvent(event);
    }
}

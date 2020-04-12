package cc.gmw.carwash.shared.model.event;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);
}

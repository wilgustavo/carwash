package cc.gmw.carwash.shared.model.event;

import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@EqualsAndHashCode
public abstract class DomainEvent {
    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    }

    protected DomainEvent() {
    }

    public abstract String eventName();

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }
}
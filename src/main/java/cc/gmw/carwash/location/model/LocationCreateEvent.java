package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.event.DomainEvent;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public final class LocationCreateEvent extends DomainEvent {
    private final String name;
    private final String street;
    private final String postcode;
    private final String city;
    private final String state;
    private final String country;

    public LocationCreateEvent(String id, String name, String street, String postcode, String city, String state, String country) {
        super(id);
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String eventName() {
        return "location.created";
    }

}

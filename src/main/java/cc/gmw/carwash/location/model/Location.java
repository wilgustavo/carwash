package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Location extends AggregateRoot {
    @NonNull private final LocationId id;
    @NonNull private final LocationName name;
    @NonNull private final LocationAddress address;

    public static Location create(LocationId id, LocationName name, LocationAddress address) {
        Location location = new Location(id, name, address);
        LocationCreateEvent event = new LocationCreateEvent(id.value(), name.value(),
                address.street(), address.postcode(), address.city(), address.state(), address.country());
        location.record(event);
        return location;
    }

    public String id() {
        return id.value();
    }
    public String name() {
        return name.value();
    }
    public String street() {
        return address.street();
    }
    public String postcode() {
        return address.postcode();
    }
    public String city() {
        return address.city();
    }
    public String state() {
        return address.state();
    }
    public String coutry() {
        return address.country();
    }
}

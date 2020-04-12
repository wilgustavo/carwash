package cc.gmw.carwash.location.model;

public class LocationCreateEventMother {
    public static LocationCreateEvent fromLocation(Location location) {
        return new LocationCreateEvent(location.id(), location.name(), location.street(), location.postcode(),
                location.city(), location.state(), location.coutry());
    }
}

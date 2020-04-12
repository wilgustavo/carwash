package cc.gmw.carwash.location.model;

import cc.gmw.carwash.location.application.create.CreateLocationCommand;

import java.util.UUID;

public final class LocationMother {

    public static Location fromCreateCommand(CreateLocationCommand command) {
        LocationId locationId = new LocationId(UUID.fromString(command.getId()));
        LocationName locationName = new LocationName(command.getName());
        LocationAddress locationAddress = new LocationAddress(command.getStreet(), command.getPostcode(),
                command.getCity(), command.getState(), command.getCountry());
        return new Location(locationId, locationName, locationAddress);
    }
}

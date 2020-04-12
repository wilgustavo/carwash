package cc.gmw.carwash.location.application.create;

import cc.gmw.carwash.location.model.LocationAddress;
import cc.gmw.carwash.location.model.LocationId;
import cc.gmw.carwash.location.model.LocationName;
import cc.gmw.carwash.shared.model.Service;
import cc.gmw.carwash.shared.model.command.CommandHandler;

import java.util.UUID;

@Service
public class CreateLocationCommandHandler implements CommandHandler<CreateLocationCommand> {

    private final LocationCreator locationCreator;

    public CreateLocationCommandHandler(LocationCreator locationCreator) {
        this.locationCreator = locationCreator;
    }

    @Override
    public void handle(CreateLocationCommand command) {
        LocationId id = new LocationId(UUID.fromString(command.getId()));
        LocationName name = new LocationName(command.getName());
        LocationAddress address = new LocationAddress(command.getStreet(), command.getPostcode(), command.getCity(),
                command.getState(), command.getCountry());
        locationCreator.create(id, name, address);
    }

}

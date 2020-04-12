package cc.gmw.carwash.api.location.create;

import cc.gmw.carwash.location.application.create.CreateLocationCommand;
import cc.gmw.carwash.shared.model.command.CommandBus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class LocationPostController {
    private final CommandBus commandBus;

    public LocationPostController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping("/locations")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateLocationRequest request) {
        CreateLocationCommand command = new CreateLocationCommand(request.getId(), request.getName(),
                request.getStreet(), request.getPostcode(), request.getCity(), request.getState(), request.getCountry());
        commandBus.dispatch(command);
    }

}

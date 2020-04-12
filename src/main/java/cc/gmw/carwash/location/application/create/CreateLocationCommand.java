package cc.gmw.carwash.location.application.create;

import cc.gmw.carwash.shared.model.command.Command;
import lombok.Value;

@Value
public class CreateLocationCommand implements Command {
    String id;
    String name;
    String  street;
    String postcode;
    String city;
    String state;
    String country;
}

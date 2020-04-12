package cc.gmw.carwash.location.application.create;

import cc.gmw.carwash.shared.model.StringMother;

import java.util.UUID;

class CreateLocationCommandMother  {
    static CreateLocationCommand random() {
        String id = UUID.randomUUID().toString();
        String name = StringMother.random(100);
        String street = StringMother.random(200);
        String postcode = StringMother.random(10);
        String city = StringMother.random(50);
        String state = StringMother.random(2);
        String country = StringMother.random(2);

        return new CreateLocationCommand(id, name, street, postcode, city, state, country);
    }
}

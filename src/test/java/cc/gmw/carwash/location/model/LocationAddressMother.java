package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringMother;

public class LocationAddressMother {
    public static LocationAddress random() {
        String street = StringMother.random(200);
        String postcode = StringMother.random(10);
        String city = StringMother.random(50);
        String state = StringMother.random(2);
        String country = StringMother.random(2);
        return new LocationAddress(street, postcode, city, state, country);
    }
}

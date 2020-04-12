package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationAddressTest {

    @Test
    void shouldReturnAddressValues() {
        String street = StringMother.random(200);
        String postcode = StringMother.random(10);
        String city = StringMother.random(50);
        String state = StringMother.random(2);
        String country = StringMother.random(20);
        LocationAddress locationAddress = new LocationAddress(street, postcode, city, state, country);
        assertEquals(street, locationAddress.street());
        assertEquals(postcode, locationAddress.postcode());
        assertEquals(city, locationAddress.city());
        assertEquals(state, locationAddress.state());
        assertEquals(country, locationAddress.country());
    }

}
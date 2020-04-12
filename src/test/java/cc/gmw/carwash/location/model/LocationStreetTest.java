package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationStreetTest {

    @Test
    void shouldReturnStreetValue() {
        String street = StringMother.random(200);
        LocationStreet locationStreet =  new LocationStreet(street);
        assertEquals(street, locationStreet.value());
    }

    @Test
    void shouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new LocationStreet(null));
        assertThrows(IllegalArgumentException.class, () -> new LocationStreet(""));
    }

    @Test
    void shouldNotExceed200Length() {
        String badStreet = StringMother.random(201);
        assertEquals(201, badStreet.length());
        assertThrows(IllegalArgumentException.class, () -> new LocationStreet(badStreet));
    }

}
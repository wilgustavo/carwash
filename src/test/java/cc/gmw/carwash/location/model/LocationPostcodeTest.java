package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationPostcodeTest {

    @Test
    void shouldReturnPostCodeValue() {
        String postalCode = StringMother.random(10);
        LocationPostcode locationPostcode = new LocationPostcode(postalCode);
        assertEquals(postalCode, locationPostcode.value());
    }

    @Test
    void shouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new LocationPostcode(null));
        assertThrows(IllegalArgumentException.class, () -> new LocationPostcode(""));
    }

    @Test
    void shouldNotExceed200Length() {
        String badPostcode = StringMother.random(11);
        assertEquals(11, badPostcode.length());
        assertThrows(IllegalArgumentException.class, () -> new LocationPostcode(badPostcode));
    }

}
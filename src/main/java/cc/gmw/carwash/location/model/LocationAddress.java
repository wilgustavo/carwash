package cc.gmw.carwash.location.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationAddress {
    private LocationStreet street;
    private LocationPostcode postcode;
    private LocationCity city;
    private LocationState state;
    private LocationCountry country;

    public LocationAddress(String street, String postcode, String city, String state, String country) {
        this.street = new LocationStreet(street);
        this.postcode = new LocationPostcode(postcode);
        this.city = new LocationCity(city);
        this.state = new LocationState(state);
        this.country = new LocationCountry(country);
    }

    public String street() {
        return street.value();
    }

    public String postcode() {
        return postcode.value();
    }

    public String city() {
        return city.value();
    }

    public String state() {
        return state.value();
    }

    public String country() {
        return country.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationAddress)) return false;
        LocationAddress that = (LocationAddress) o;
        return street.equals(that.street) &&
                postcode.equals(that.postcode) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postcode, city, state, country);
    }
}

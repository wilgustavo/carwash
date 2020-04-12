package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationCountry extends StringValue {

    private static final Integer MAX_LENGTH = 20;

    public LocationCountry(String country) {
        shouldNotBeEmpty(country, "Country must not be empty");
        shouldNotExceedMaxLength(country, MAX_LENGTH, String.format("Country must not exceed %d characters", MAX_LENGTH));
        value = country;
    }
}

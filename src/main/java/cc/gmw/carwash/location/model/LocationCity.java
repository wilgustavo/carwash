package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationCity extends StringValue {

    private static final Integer MAX_LENGTH = 50;

    public LocationCity(String city) {
        shouldNotBeEmpty(city, "City must not be empty");
        shouldNotExceedMaxLength(city, MAX_LENGTH, String.format("City must not exceed %d characters", MAX_LENGTH));
        value = city;
    }
}

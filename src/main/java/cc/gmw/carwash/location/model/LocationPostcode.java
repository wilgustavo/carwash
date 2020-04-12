package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationPostcode extends StringValue {

    private static final int MAX_LENGTH = 10;

    public LocationPostcode(String postcode) {
        shouldNotBeEmpty(postcode, "Postal code must not be empty");
        shouldNotExceedMaxLength(postcode, MAX_LENGTH, String.format("Postal code must not exceed %d characters", MAX_LENGTH));
        value = postcode;
    }

}

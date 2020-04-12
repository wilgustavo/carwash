package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationStreet extends StringValue {

    private static final int MAX_LENGTH = 200;

    public LocationStreet(String street) {
        shouldNotBeEmpty(street, "Street should not be empty");
        shouldNotExceedMaxLength(street, MAX_LENGTH, String.format("Street must not exceed %d characters", MAX_LENGTH));
        value = street;
    }

}

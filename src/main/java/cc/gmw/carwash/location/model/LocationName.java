package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationName extends StringValue {

    private static final int MAX_LENGTH = 100;

    public LocationName(String name) {
        shouldNotBeEmpty(name, "Name must not be empty");
        shouldNotExceedMaxLength(name, MAX_LENGTH, String.format("Name must not exceed %d characters", MAX_LENGTH));
        value = name;
    }
}

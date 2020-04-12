package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.StringValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationState extends StringValue {

    private static final int MAX_LENGTH = 2;

    public LocationState(String state) {
        shouldNotBeEmpty(state, "State must not be empty");
        shouldNotExceedMaxLength(state, MAX_LENGTH, String.format("State must not exceed %d characters", MAX_LENGTH));
        value = state;
    }
}

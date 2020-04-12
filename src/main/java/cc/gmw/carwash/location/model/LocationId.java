package cc.gmw.carwash.location.model;

import cc.gmw.carwash.shared.model.IdValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationId extends IdValue {
    public LocationId(UUID id) {
        super(id);
    }
}

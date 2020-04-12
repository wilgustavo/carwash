package cc.gmw.carwash.shared.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdValue implements Serializable {
    protected String value;
    public IdValue(UUID id) {
        value = id.toString();
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdValue)) return false;
        IdValue idValue = (IdValue) o;
        return value.equals(idValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

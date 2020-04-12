package cc.gmw.carwash.shared.model;

import java.util.Objects;

public class StringValue {
    protected String value;

    public String value() {
        return value;
    }

    protected void shouldNotBeEmpty(String value, String message) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void shouldNotExceedMaxLength(String value, Integer max, String message) {
        if (value.length() > max) {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValue that = (StringValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

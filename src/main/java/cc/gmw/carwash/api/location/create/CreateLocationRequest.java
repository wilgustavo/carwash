package cc.gmw.carwash.api.location.create;

import lombok.Value;

@Value
public class CreateLocationRequest {
    String id;
    String name;
    String  street;
    String postcode;
    String city;
    String state;
    String country;
}

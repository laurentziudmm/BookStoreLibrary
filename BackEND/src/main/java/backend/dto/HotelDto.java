package backend.dto;

import backend.model.Address;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class HotelDto {

    private BigInteger id;
    private String name;
    private String rating;
    private String description;
    private Address addressId;
}

package backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import backend.model.Address;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class UserDto {

    @JsonIgnore
    private BigInteger id;

    private String firstName;
    private String surname;
    private String password;
    private String confirmedPassword;
    private Address address;
}

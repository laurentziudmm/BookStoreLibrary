package backend.dto;

import backend.model.RoomStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class RoomDto {

    private BigInteger id;
    private String type;
    private RoomStatus status;
    private String description;
    private double price;
}

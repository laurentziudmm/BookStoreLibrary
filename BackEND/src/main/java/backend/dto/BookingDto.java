package backend.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder
public class BookingDto {

    private BigInteger userId;
    private BigInteger roomId;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
}

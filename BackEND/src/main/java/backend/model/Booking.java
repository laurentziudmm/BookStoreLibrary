package backend.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity(name = "Booking")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "check_in")
    LocalDateTime checkIn;

    @Column(name = "check_out")
    LocalDateTime checkOut;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @ToString.Exclude
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}

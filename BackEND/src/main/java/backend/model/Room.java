package backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity(name = "Room")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "floor")
    private int floor;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    public Room(int floor, String type, RoomStatus status, String description,
                double price, Hotel hotel, List<Booking> bookings) {
        this.floor = floor;
        this.type = type;
        this.status = status;
        this.description = description;
        this.price = price;
        this.hotel = hotel;
        this.bookings = bookings;
    }
}

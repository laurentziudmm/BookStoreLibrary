package backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity(name = "Hotel")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private String rating;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    public Hotel(String name, String rating, String description, Address address, List<Room> rooms) {
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.address = address;
        this.rooms = rooms;
    }
}

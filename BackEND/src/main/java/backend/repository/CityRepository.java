package backend.repository;

import backend.model.Address;
import backend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<Address, BigInteger> {

    @Query("select h from Hotel h inner join Address a on " +
            "h.address = a.id where a.city like :cityName")
    List<Hotel> findAllHotelsByCity(String cityName);
}

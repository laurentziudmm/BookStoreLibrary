package backend.repository;

import backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, BigInteger> {

    Optional<Room> findById(BigInteger bigInteger);
}

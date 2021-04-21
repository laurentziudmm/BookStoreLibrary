package backend.validator;

import backend.exception.BookedRoomException;
import backend.exception.ResourceNotFoundException;
import backend.model.Room;
import backend.model.RoomStatus;
import backend.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class BookingValidator {

    private RoomRepository roomRepository;

    public void validateBooking(BigInteger roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found!"));
        if (room.getStatus().equals(RoomStatus.RESERVED)) {
            throw new BookedRoomException("Room is booked!");
        }
    }
}

package backend.service;

import backend.model.Booking;
import backend.model.Room;
import backend.model.RoomStatus;
import backend.repository.BookingRepository;
import backend.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@EnableScheduling
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UnbookingRoomService {

    private RoomRepository roomRepository;
    private BookingRepository bookingRepository;

    @Scheduled(cron = "0 0 12 ? * *")
    public void unbookRoom() {
        List<Booking> bookingList = bookingRepository.findAll();
        for (Booking booked : bookingList) {
            ZonedDateTime zonedDateTime = booked.getCheckOut().atZone(ZoneId.of("Europe/Bucharest"));
            if (zonedDateTime.toInstant().toEpochMilli() <= System.currentTimeMillis()) {
                Room room = booked.getRoom();
                room.setStatus(RoomStatus.FREE);
                roomRepository.save(room);
            }
        }
    }
}


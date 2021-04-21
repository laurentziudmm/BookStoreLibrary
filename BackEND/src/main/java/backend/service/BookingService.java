package backend.service;

import backend.dto.BookingDto;
import backend.mapper.BookingMapper;
import backend.model.Booking;
import backend.model.Room;
import backend.model.RoomStatus;
import backend.model.User;
import backend.repository.BookingRepository;
import backend.repository.RoomRepository;
import backend.repository.UserRepository;
import backend.validator.BookingValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class BookingService {

    private BookingValidator bookingValidator;
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private BookingRepository bookingRepository;


    public ResponseEntity addBooking(BookingDto bookingDto) {
        try {
            bookingValidator.validateBooking(bookingDto.getRoomId());
            User user = userRepository.findById(bookingDto.getUserId()).orElseThrow();
            Room room = roomRepository.findById(bookingDto.getRoomId()).orElseThrow();
            double totalPrice = calculateTotalPrice(bookingDto, room.getPrice());
            Booking booking = BookingMapper.toEntity(bookingDto, room, user, totalPrice);
            room.setStatus(RoomStatus.RESERVED);
            roomRepository.save(room);
            bookingRepository.save(booking);
            return ResponseEntity.ok(bookingDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private double calculateTotalPrice(BookingDto bookingDto, double pricePerDay) {
        long range = ChronoUnit.DAYS.between(bookingDto.getCheckInDate(),
                bookingDto.getCheckOutDate());
        return range * pricePerDay;
    }
}

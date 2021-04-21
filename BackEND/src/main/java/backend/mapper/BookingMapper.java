package backend.mapper;

import backend.dto.BookingDto;
import backend.model.Booking;
import backend.model.Room;
import backend.model.User;

public class BookingMapper {

    public static BookingDto toDto(Booking booking) {
        return BookingDto.builder()
                .roomId(booking.getRoom().getId())
                .userId(booking.getUser().getId())
                .checkInDate(booking.getCheckIn())
                .checkOutDate(booking.getCheckOut())
                .build();
    }

    public static Booking toEntity(BookingDto bookingDto, Room room,
                                   User user, double totalPrice) {
        return Booking.builder()
                .checkIn(bookingDto.getCheckInDate())
                .checkOut(bookingDto.getCheckOutDate())
                .room(room)
                .user(user)
                .totalPrice(totalPrice)
                .build();
    }
}

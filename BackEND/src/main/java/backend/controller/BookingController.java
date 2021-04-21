package backend.controller;

import backend.dto.BookingDto;
import backend.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class BookingController extends BaseAppController {

    private static final String API_NAME = "booking";

    BookingService bookingService;

    @PostMapping(BookingController.API_NAME)
    public ResponseEntity bookRoom(@RequestBody BookingDto bookingDto) {
        return bookingService.addBooking(bookingDto);
    }
}

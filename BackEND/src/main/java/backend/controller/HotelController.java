package backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController extends BaseAppController {

    public static final String API_NAME = "hotels";

    @GetMapping(HotelController.API_NAME + "/rooms")
    public ResponseEntity<String> getListOfRooms() {
        return ResponseEntity.ok("List of rooms!");
    }

    @GetMapping(HotelController.API_NAME + "/rooms/{status}")
    public ResponseEntity<String> getListOfRoomsByStatus(@PathVariable(value
            = "status") String status) {
        return ResponseEntity.ok("List of rooms that are " + status);
    }
}

package backend.controller;

import backend.dto.RoomDto;
import backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class RoomController extends BaseAppController {

    public static final String API_NAME = "rooms";

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(RoomController.API_NAME + "/{id}")
    public ResponseEntity<RoomDto> getRoomDescription(@PathVariable BigInteger id) {
        return ResponseEntity.ok(roomService.getRoomDescription(id));
    }
}

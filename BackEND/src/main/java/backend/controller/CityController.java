package backend.controller;

import backend.dto.HotelDto;
import backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController extends BaseAppController {

    public static final String API_NAME = "cities";

    private CityService hotelService;

    @Autowired
    public CityController(CityService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(CityController.API_NAME + "/{cityName}")
    public ResponseEntity<List<HotelDto>> getListOfHotels(@PathVariable String cityName) {
        return ResponseEntity.ok(hotelService.getAllHotelsFromCity(cityName));
    }
}

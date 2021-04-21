package backend.mapper;

import backend.dto.HotelDto;
import backend.model.Hotel;

public class HotelMapper {

    public static HotelDto toDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .rating(hotel.getRating())
                .description(hotel.getDescription())
                .addressId(hotel.getAddress())
                .build();
    }
}

package backend.mapper;

import backend.dto.RoomDto;
import backend.model.Room;

public class RoomMapper {

    public static RoomDto toDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .type(room.getType())
                .status(room.getStatus())
                .description(room.getDescription())
                .price(room.getPrice())
                .build();
    }
}

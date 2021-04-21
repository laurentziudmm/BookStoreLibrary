package backend.service;

import backend.dto.RoomDto;
import backend.exception.ResourceNotFoundException;
import backend.mapper.RoomMapper;
import backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDto getRoomDescription(BigInteger id) {
        return roomRepository.findById(id)
                .map(RoomMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Room with " +
                        "id " + id + " does not exist!"));
    }
}

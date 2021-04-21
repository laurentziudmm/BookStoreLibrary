package backend.service;

import backend.dto.HotelDto;
import backend.mapper.HotelMapper;
import backend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<HotelDto> getAllHotelsFromCity(String cityName) {
        return cityRepository.findAllHotelsByCity(cityName).stream()
                .map(HotelMapper::toDto)
                .collect(Collectors.toList());
    }
}

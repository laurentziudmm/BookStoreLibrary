package backend.mapper;

import backend.dto.UserDto;
import backend.model.User;

public class UserMapper {

    public static User toEntity(UserDto UserDto) {
        return User.builder()
                .id(UserDto.getId())
                .firstName(UserDto.getFirstName())
                .surname(UserDto.getSurname())
                .password(UserDto.getPassword())
                .address(UserDto.getAddress())
                .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .address(user.getAddress())
                .build();
    }
}


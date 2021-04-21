package backend.service;

import backend.dto.LoginRequestDto;
import backend.dto.UserDto;
import backend.mapper.UserMapper;
import backend.model.Address;
import backend.model.User;
import backend.repository.UserRepository;
import backend.validator.LoginUserValidator;
import backend.validator.RegisterUserValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService {

    private UserRepository userRepository;
    private RegisterUserValidator registerUserValidator;
    private LoginUserValidator loginUserValidator;

    public ResponseEntity registerUser(UserDto userDto) {
        try {
            User user = registerUserValidator.checkIfPasswordAndConfirmPasswordMatch(userDto);
            Address address = userDto.getAddress();
            registerUserValidator.checkIfUserDtoFieldsAndAddressFieldsAreEmpty(userDto, address);
            registerUserValidator.validateUserEmailAddress(address);
            user.setAddress(address);
            userRepository.save(user);
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity loginUser(LoginRequestDto loginRequestDto) {
        try {
            User user = loginUserValidator.validateUserLogin(loginRequestDto);
            return ResponseEntity.ok(UserMapper.toDto(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


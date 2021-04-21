package backend.validator;

import backend.dto.UserDto;
import backend.mapper.UserMapper;
import backend.model.Address;
import backend.model.User;
import backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class RegisterUserValidator {

    private UserRepository userRepository;

    public void validateUserEmailAddress(Address address) throws Exception {
        String tempEmail = address.getEmailAddress();
        if (tempEmail != null && !"".equals(tempEmail)) {
            Optional<User> user = userRepository.findUserByEmailAddress(tempEmail);
            if (user.isPresent()) {
                throw new Exception("User with " + tempEmail + " already exists!");
            }
        }
    }

    public User checkIfPasswordAndConfirmPasswordMatch(UserDto userDto) throws Exception {
        if (checkIfPasswordsMatch(userDto)) {
            return UserMapper.toEntity(userDto);
        } else {
            throw new Exception("Password and Confirmed Password doesn't match!");
        }
    }

    public void checkIfUserDtoFieldsAndAddressFieldsAreEmpty(UserDto userDto, Address address) throws Exception {
        checkIfUserDtoFieldsAreEmpty(userDto);
        checkIfAddressFieldsAreEmpty(address);
    }

    private void checkIfUserDtoFieldsAreEmpty(UserDto userDto) throws Exception {
        if (userDto.getFirstName().equals("") || userDto.getSurname().equals("") ||
                userDto.getPassword().equals("") || userDto.getConfirmedPassword().equals("")) {
            throw new Exception("Required fields left empty");
        }
    }

    private void checkIfAddressFieldsAreEmpty(Address address) throws Exception {
        if (address.getCountry().equals("") || address.getCounty().equals("") ||
                address.getCity().equals("") || address.getStreetAddress().equals("") ||
                address.getPostalCode().equals("") || address.getPhoneNumber().equals("") ||
                address.getEmailAddress().equals("")) {
            throw new Exception("Required fields left empty");
        }
    }

    private boolean checkIfPasswordsMatch(UserDto userDto) {
        return userDto.getPassword().equals(userDto.getConfirmedPassword());
    }
}

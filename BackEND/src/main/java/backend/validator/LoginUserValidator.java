package backend.validator;

import backend.dto.LoginRequestDto;
import backend.model.User;
import backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class LoginUserValidator {

    private UserRepository userRepository;

    public User validateUserLogin(LoginRequestDto loginRequestDto) throws Exception {
        Optional<User> user = userRepository.findUserByEmailAddressAndPassword(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("Bad credentials!");
        }
    }
}


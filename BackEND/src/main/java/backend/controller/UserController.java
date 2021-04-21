package backend.controller;

import backend.dto.LoginRequestDto;
import backend.dto.UserDto;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
public class UserController extends BaseAppController {

    public static final String API_NAME = "users";

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(UserController.API_NAME + "/register")
    public ResponseEntity userRegistration(@RequestBody UserDto UserDto) {
        return userService.registerUser(UserDto);
    }

    @PostMapping(UserController.API_NAME + "/login")
    public ResponseEntity userLogin(@RequestBody LoginRequestDto loginRequestDto) {
        return userService.loginUser(loginRequestDto);
    }
}

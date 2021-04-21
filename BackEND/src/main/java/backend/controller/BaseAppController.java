package backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseAppController.API_V1)
public class BaseAppController {

    public static final String API_V1 = "/api/v1";
}

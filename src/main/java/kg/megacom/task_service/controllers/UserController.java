package kg.megacom.task_service.controllers;

import kg.megacom.task_service.models.User;
import kg.megacom.task_service.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }
}

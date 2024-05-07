package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @DeleteMapping("/delete{id}")
    public void deleteUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userService.deleteUser(userDTO,id);
    }

    @GetMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @GetMapping("/find-all")
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }
}

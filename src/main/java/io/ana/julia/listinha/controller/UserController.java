package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createUserDto = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserDto);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO updateUserDto = userService.updateUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateUserDto);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> findAllUsersDto = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(findAllUsersDto);
    }
}

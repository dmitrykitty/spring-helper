package com.dnikitin.springwebdemo.web.controller;

import com.dnikitin.springwebdemo.model.User;
import com.dnikitin.springwebdemo.service.UserService;
import com.dnikitin.springwebdemo.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestHeader(name = "X-Need-Size", defaultValue = "false") Boolean needSize) {
        List<UserDto> users = userService.findAll().stream()
                .map(this::toDto)
                .toList();

        if (needSize) {
            return ResponseEntity.
                    ok().
                    header("X-User-List-Size", String.valueOf(users.size())).
                    body(users);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(toDto(userService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        var createUser = userService.create(toEntity(userDto));
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(toDto(createUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
        var updateUser = userService.update(id, toEntity(userDto));
        return ResponseEntity.ok(toDto(updateUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getAge());
    }

    private User toEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getAge());
    }
}

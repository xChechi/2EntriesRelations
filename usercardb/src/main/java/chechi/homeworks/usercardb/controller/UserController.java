package chechi.homeworks.usercardb.controller;

import chechi.homeworks.usercardb.dto.UserRequest;
import chechi.homeworks.usercardb.dto.UserResponse;
import chechi.homeworks.usercardb.dto.UserUpdateRequest;
import chechi.homeworks.usercardb.entity.User;
import chechi.homeworks.usercardb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers () {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser (@PathVariable int id) {

        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<String> postUser (@Valid @RequestBody UserRequest request) {

        UserResponse userResponse = userService.createUser(request);

        if(!(userResponse.getError() == null)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist in our database");
        }

        String response = String.format("User with name %s %s was created",
                userResponse.getFirstName(), userResponse.getLastName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable int id, @Valid @RequestBody UserUpdateRequest request) {

        UserResponse response = userService.updateUser(id,request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User with ID: " + id + " has been deleted");
    }


}

package chechi.homeworks.usercardb.service;

import chechi.homeworks.usercardb.dto.UserRequest;
import chechi.homeworks.usercardb.dto.UserResponse;
import chechi.homeworks.usercardb.dto.UserUpdateRequest;
import chechi.homeworks.usercardb.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers ();

    UserResponse getUserById (int id);

    void deleteUser (int id);

    UserResponse createUser (UserRequest request);

    boolean existsByEmail(String email);

    UserResponse updateUser(int id, UserUpdateRequest request);
}

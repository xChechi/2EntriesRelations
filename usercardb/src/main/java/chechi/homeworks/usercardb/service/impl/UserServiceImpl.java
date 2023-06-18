package chechi.homeworks.usercardb.service.impl;

import chechi.homeworks.usercardb.converter.UserConverter;
import chechi.homeworks.usercardb.dto.UserRequest;
import chechi.homeworks.usercardb.dto.UserResponse;
import chechi.homeworks.usercardb.dto.UserUpdateRequest;
import chechi.homeworks.usercardb.entity.User;
import chechi.homeworks.usercardb.exception.UserNotFoundException;
import chechi.homeworks.usercardb.repository.UserRepository;
import chechi.homeworks.usercardb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> { throw new UserNotFoundException( "User with ID " + id + " not found."); });
        return userConverter.toUserResponse(user);
    }

    @Override
    public void deleteUser(int id) {

        userRepository.deleteById(id);
    }

    @Override
    public UserResponse createUser(UserRequest request) {

        if (existsByEmail(request.getEmail())) {
            return userConverter.toError("User with the same email already exists");
        }

        User user = userConverter.createUser(request);
        User savedUser = userRepository.save(user);
        return userConverter.toUserResponse(savedUser);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findAll().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public UserResponse updateUser(int id, UserUpdateRequest request) {

        User user = userRepository.findById(id).orElseThrow(() -> { throw new UserNotFoundException( "User with ID " + id + " not found."); });

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userConverter.toUserResponse(userRepository.save(user));
    }

}

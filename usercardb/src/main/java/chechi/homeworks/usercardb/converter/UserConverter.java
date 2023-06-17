package chechi.homeworks.usercardb.converter;

import chechi.homeworks.usercardb.dto.UserRequest;
import chechi.homeworks.usercardb.dto.UserResponse;
import chechi.homeworks.usercardb.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User createUser (UserRequest request) {

        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toUserResponse (User user) {

        return new UserResponse(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getCars());
    }

    public UserResponse toError (String error) {

        return new UserResponse(error);
    }
}

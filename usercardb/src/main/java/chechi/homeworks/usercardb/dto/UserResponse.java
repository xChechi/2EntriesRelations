package chechi.homeworks.usercardb.dto;

import chechi.homeworks.usercardb.entity.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotBlank
    private String password;

    private Set<Car> cars;

    @JsonIgnore
    private String error;

    public UserResponse(String error) {
        this.error = error;
    }

    public UserResponse(String firstName, String lastName, String email, String password, Set<Car> cars) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cars = cars;
    }
}

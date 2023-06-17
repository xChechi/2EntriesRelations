package chechi.homeworks.usercardb.controller;

import chechi.homeworks.usercardb.dto.CarRequest;
import chechi.homeworks.usercardb.dto.CarResponse;
import chechi.homeworks.usercardb.dto.UserResponse;
import chechi.homeworks.usercardb.entity.Car;
import chechi.homeworks.usercardb.entity.User;
import chechi.homeworks.usercardb.repository.UserRepository;
import chechi.homeworks.usercardb.service.CarService;
import chechi.homeworks.usercardb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping("/{id}/cars")
    public ResponseEntity<Set<Car>> getAllCarsByUser (User user) {

        return ResponseEntity.status(HttpStatus.FOUND).body(carService.getCarsByUser(user));
    }

    @GetMapping("/{id}/cars/{carId}")
    public ResponseEntity<CarResponse> getCar (@PathVariable int carId) {

        return ResponseEntity.status(HttpStatus.FOUND).body(carService.getCarById(carId));

    }

        @PostMapping("/{id}/cars")
        public ResponseEntity<String> postCar (@PathVariable int id, @Valid @RequestBody CarRequest request) {

            CarResponse carResponse = carService.addCar(id, request);

            String response = String.format("%s %s was created",
                    carResponse.getMake(), carResponse.getModel());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        }

    @DeleteMapping("/{id}/cars/{carId}")
    public HttpStatus deleteCar (@PathVariable int carId) {

        carService.deleteCar(carId);
        return HttpStatus.OK;
    }


}

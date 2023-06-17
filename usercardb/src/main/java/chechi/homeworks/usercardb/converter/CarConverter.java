package chechi.homeworks.usercardb.converter;

import chechi.homeworks.usercardb.dto.CarRequest;
import chechi.homeworks.usercardb.dto.CarResponse;
import chechi.homeworks.usercardb.entity.Car;
import chechi.homeworks.usercardb.entity.User;
import chechi.homeworks.usercardb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    @Autowired
    UserRepository userRepository;

    public Car createCar (int userId, CarRequest request) {

        User user = userRepository.findById(userId).get();

        return Car.builder()
                .make(request.getMake())
                .model(request.getModel())
                .vin(request.getVin())
                .plate(request.getPlate())
                .user(user)
                .build();

    }

    public CarResponse toCarResponse (Car car) {

        return new CarResponse(car.getMake(), car.getModel(), car.getVin(), car.getPlate());
    }
}

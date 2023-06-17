package chechi.homeworks.usercardb.service;


import chechi.homeworks.usercardb.dto.CarRequest;
import chechi.homeworks.usercardb.dto.CarResponse;
import chechi.homeworks.usercardb.entity.Car;
import chechi.homeworks.usercardb.entity.User;

import java.util.Set;

public interface CarService {

    Set<Car> getCarsByUser(User user);

    CarResponse getCarById (int id);

    void deleteCar (int id);

    CarResponse addCar(int id, CarRequest request);

    CarRequest updateCar (CarRequest request);

}

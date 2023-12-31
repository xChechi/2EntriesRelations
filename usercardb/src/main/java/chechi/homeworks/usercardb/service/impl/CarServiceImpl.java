package chechi.homeworks.usercardb.service.impl;

import chechi.homeworks.usercardb.converter.CarConverter;
import chechi.homeworks.usercardb.dto.CarRequest;
import chechi.homeworks.usercardb.dto.CarResponse;
import chechi.homeworks.usercardb.entity.Car;
import chechi.homeworks.usercardb.entity.User;
import chechi.homeworks.usercardb.exception.CarNotFoundException;
import chechi.homeworks.usercardb.repository.CarRepository;
import chechi.homeworks.usercardb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }


    @Override
    public CarResponse getCarById(int id) {
        Car car = carRepository.findById(id).orElseThrow(() -> { throw new CarNotFoundException( "Car with ID " + id + " not found."); });
        return carConverter.toCarResponse(car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarResponse addCar(int id, CarRequest request) {

        Car car = carConverter.createCar(id, request);
        Car savedCar = carRepository.save(car);
        return carConverter.toCarResponse(savedCar);
    }

    @Override
    public CarResponse updateCar(int id, CarRequest request) {

        Car car = carRepository.findById(id).orElseThrow(() -> { throw new CarNotFoundException( "Car with ID " + id + " not found."); });

        car.setMake(request.getMake());
        car.setModel(request.getModel());
        car.setVin(request.getVin());
        car.setPlate(request.getPlate());

        return carConverter.toCarResponse(carRepository.save(car));
    }

    public Set<Car> getCarsByUser(User user) {
        return carRepository.findByUser(user);
    }

}

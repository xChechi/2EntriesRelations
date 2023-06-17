package chechi.homeworks.usercardb.repository;

import chechi.homeworks.usercardb.entity.Car;
import chechi.homeworks.usercardb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Set<Car> findByUser(User user);
}

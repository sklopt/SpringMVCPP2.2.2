package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> listCar = new ArrayList<>();

    static {
        listCar.add(new Car("Chevrolet Tahoe", 2021, "orange"));
        listCar.add(new Car("Toyota L200", 2020, "white"));
        listCar.add(new Car("Hyundai Palisade", 2022, "grey"));
        listCar.add(new Car("Mazda CX-9", 2019, "red"));
        listCar.add(new Car("Volvo XC-90", 2023, "black"));

    }

    @Override
    public List<Car> getListCar(int count) {
        if (count == 0) {
            return listCar;
        }
        return listCar.stream().limit(count).collect(Collectors.toList());
    }
}

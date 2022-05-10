package hu.unideb.inf.model;

import java.util.List;

public interface CarDAO extends AutoCloseable {
    //CRUD methods
    public void saveCar(Car a); //C

    public void deleteCar(Car a); //D

    public void updateCar(Car a); //U

    public List<Car> getCar(); //R

    public List<Car> getCarAll();

    //SELECT * FROM CAR where brand like 'Audi'
    List<Car> getCarByBrand(String brand);

    List<Car> getCarByLowerPrice(String lower);

    List<Car> getCarByUpperPrice(String upper);

    List<Car> getCarByType(String type);

    List<Car> getCarByColor(String color);

    List<Car> getCarByPerson(String person);

    List<Car> getCarByFuel(String fuel);
}

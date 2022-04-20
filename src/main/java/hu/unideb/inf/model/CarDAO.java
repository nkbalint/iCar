package hu.unideb.inf.model;

import java.util.List;

public interface CarDAO extends AutoCloseable {
    //CRUD methods
    public void saveCar(Car a); //C

    public void deleteCar(Car a); //D

    public void updateCar(Car a); //U

    public List<Car> getCar(); //R

    public List<Car> getCarAll();
}
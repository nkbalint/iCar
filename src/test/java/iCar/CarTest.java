package iCar;

import hu.unideb.inf.model.Car;
import hu.unideb.inf.model.JpaCarDAO;
import hu.unideb.inf.model.JpaUserDAO;
import hu.unideb.inf.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private JpaCarDAO cDAO = new JpaCarDAO();
    private List<Car> cars = cDAO.getCarAll();
    private Car car;

    // autó hozzáadását végző függvény tesztje
    @Test
    void addcar() throws Exception {
        Car.addcar("teszt", "teszt", 2000, "teszt", 100, "teszt", "teszt", 10, 200, 5, "teszt", "teszt", 500000 );
        Car expected = new Car("teszt", "teszt", 2000, "teszt", 100, "teszt", "teszt", 10, 200, 5, "teszt", "teszt", 500000 );

        assertEquals(expected.getBrand(), cars.get(cars.size() - 1).getBrand());
        assertEquals(expected.getType(), cars.get(cars.size() - 1).getType());
        assertEquals(expected.getYear(), cars.get(cars.size() - 1).getYear());
        assertEquals(expected.getFuel(), cars.get(cars.size() - 1).getFuel());
        assertEquals(expected.getKm(), cars.get(cars.size() - 1).getKm());
        assertEquals(expected.getLook(), cars.get(cars.size() - 1).getLook());
        assertEquals(expected.getPerson(), cars.get(cars.size() - 1).getPerson());
        assertEquals(expected.getCrowd(), cars.get(cars.size() - 1).getCrowd());
        assertEquals(expected.getRolling(), cars.get(cars.size() - 1).getRolling());
        assertEquals(expected.getPerformance(), cars.get(cars.size() - 1).getPerformance());
        assertEquals(expected.getGearbox(), cars.get(cars.size() - 1).getGearbox());
        assertEquals(expected.getColour(), cars.get(cars.size() - 1).getColour());
        assertEquals(expected.getPrice(), cars.get(cars.size() - 1).getPrice());
    }
}
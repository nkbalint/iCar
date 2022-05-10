package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaCarDAO implements CarDAO{

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void saveCar(Car a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCar(Car a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCar(Car a) {
    saveCar(a);
    }

    @Override
    public List<Car> getCar() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT a FROM CAR a", User.class);
        List<User> cars = query.getResultList();
        return null;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<Car> getCarAll() {
        String sqlstr="SELECT car FROM Car car";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return query.getResultList();
    }

    //SELECT * FROM CAR where brand like 'Audi'
    @Override
    public List<Car> getCarByBrand(String brand) {
        String sqlstr="SELECT car FROM Car car WHERE BRAND="+"'"+brand+"'";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return  query.getResultList();
    }
    @Override
    public List<Car> getCarByType(String type) {
        String sqlstr="SELECT car FROM Car car WHERE TYPE="+"'"+type+"'";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return  query.getResultList();
    }
    @Override
    public List<Car> getCarByColor(String color) {
        String sqlstr="SELECT car FROM Car car WHERE COLOUR="+"'"+color+"'";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return  query.getResultList();
    }
    @Override
    public List<Car> getCarByPerson(String person) {
        String sqlstr="SELECT car FROM Car car WHERE PERSON="+"'"+person+"'";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return  query.getResultList();
    }
    @Override
    public List<Car> getCarByFuel(String fuel) {
        String sqlstr="SELECT car FROM Car car WHERE FUEL="+"'"+fuel+"'";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return  query.getResultList();
    }
    @Override
    public List<Car> getCarByLowerPrice(String lower) {
        String sqlstr="SELECT car FROM Car car WHERE PRICE >"+"'"+lower+"'";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return  query.getResultList();
    }
    @Override
    public List<Car> getCarByUpperPrice(String upper) {
        String sqlstr="SELECT car FROM Car car WHERE PRICE <"+"'"+upper+"'";
        TypedQuery<Car> query=entityManager.createQuery(sqlstr,Car.class);
        return  query.getResultList();
    }


    }





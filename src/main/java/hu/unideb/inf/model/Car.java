package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String type;
    private Integer year;
    private String fuel;
    private Integer km;
    private String look;
    private String person;
    private Integer crowd;
    private Integer rolling;
    private Integer performance;
    private String gearbox;
    private String colour;
    private Integer price;

    public Car(String brand, String type, int year, String fuel, int km, String look, String person, int crowd, Integer rolling, int performance, String gearbox, String colour, int price) {
        //this.id = id;
        this.brand = brand;
        this.type = type;
        this.year = year;
        this.fuel = fuel;
        this.km = km;
        this.look = look;
        this.person = person;
        this.crowd = crowd;
        this.rolling = rolling;
        this.performance = performance;
        this.gearbox = gearbox;
        this.colour = colour;
        this.price = price;
    }

public Car(){

}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getCrowd() {
        return crowd;
    }

    public void setCrowd(int crowd) {
        this.crowd = crowd;
    }

    public int getRolling() {
        return rolling;
    }

    public void setRolling(int rolling) {
        this.rolling = rolling;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


   public static void addcar(String brand, String type, int year, String fuel, int km, String look, String person, int crowd, int rolling, int performance, String gearbox, String colour, int price) throws Exception {
        Car car = new Car(brand, type, year, fuel, km, look, person, crowd, rolling, performance, gearbox, colour, price);
        try (CarDAO cDAO = new JpaCarDAO();) {
            cDAO.saveCar(car);
        }
    }


}
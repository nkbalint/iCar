package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class User implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String username;
    private String adress;
    private String phone;
    private String password;
    private String email;

    public User() {
    }

    public User(String adress, String username, String name, String password, String phone, String email) {
        this.name = name;
        this.username = username;
        this.adress = adress;
        this.phone = phone;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void register(String name, String username,  String adress, String phone, String password, String email) throws Exception {
        User user = new User(adress, username,  name, password, phone,email);
        try (UserDAO cDAO= new JpaUserDAO();) {
            cDAO.saveUser(user);
        }
    }
}


package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

    private String userName;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String adress;
    private String phone;
    private String password;
    public static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.[^A-Za-z]){2,})^.";
    public static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Admin(String userName) {
        this.userName = userName;
    }

    public Admin retAdmin() {
        return this;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        '}';
    }
    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName=userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password=password;
    }



    public static boolean validateEmail(String email) {
        return email.matches(VALID_EMAIL_REGEX);
    }
    public static boolean validatePassword(String password) {
        return password.matches(VALID_PASSWORD_REGEX);
    }

    public static String validateLogin(String username, String password) throws Exception {
        try (AdminDAO aDAO= new JpaAdminDAO()) {
            Admin Test = aDAO.getAdminbyName(username);

            if (username.isEmpty() || password.isEmpty()) {
                return "Enter username AND password";
            } else if (Test.getUserName().equals(username) && Test.getPassword().equals(password)) {
                return "Username AND Password OK";
            } else return "Wrong Username OR Password";
        }
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
}

package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String userName;
    private String adress;
    private String phone;
    private String password;
    private String email;
    public static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.[^A-Za-z]){2,})^.";
    public static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";

    public Admin(String userName,  String name, String adress, String phone, String password, String email) {
        this.userName = userName;
       // this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.password = password;
        this.email = email;
    }

    public Admin() {
    }

    public Admin(String userName) {
        this.userName = userName;
    }

    public static void register(String name, String username,  String adress, String phone, String password, String email) throws Exception {
        Admin admin = new Admin(username,name,adress,phone,password,email);
        try (AdminDAO cDAO= new JpaAdminDAO();) {
            cDAO.saveAdmin(admin);
        }
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

package iCar;

import hu.unideb.inf.model.JpaUserDAO;
import hu.unideb.inf.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JpaUserDAOTest {

    private JpaUserDAO uDAO;
    private List<User> users;

    @Test
    void saveUser() {
        uDAO = new JpaUserDAO();
        users = uDAO.getUserAll();
        User testuser = new User("4000 Nyíregyháza Csavar utca 7", "teszt1234", "Teszt Miklós", "Kispalimadár4321&#@", "06308888888", "tesztmiki@gmail.com");
        uDAO.saveUser(testuser);
        users = uDAO.getUserAll();

        User expected = new User("4000 Nyíregyháza Csavar utca 7", "teszt1234", "Teszt Miklós", "Kispalimadár4321&#@", "06308888888", "tesztmiki@gmail.com");

        assertEquals(expected.getAdress(), users.get(users.size() - 1).getAdress());
        assertEquals(expected.getUsername(), users.get(users.size() - 1).getUsername());
        assertEquals(expected.getName(), users.get(users.size() - 1).getName());
        assertEquals(expected.getPassword(), users.get(users.size() - 1).getPassword());
        assertEquals(expected.getPhone(), users.get(users.size() - 1).getPhone());
        assertEquals(expected.getEmail(), users.get(users.size() - 1).getEmail());
    }
}
package iCar;

import hu.unideb.inf.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private JpaUserDAO uDAO = new JpaUserDAO();
    private List<User> users;

    /*egyszerre egy adat módosítása, ebben az esteben az address lett kicserélve*/
    @Test
    void testModify1() throws Exception {
        users = uDAO.getUserAll();
        User.modify(users.get(users.size() - 1), "teszt1234","4000 Balassagyarmat Híg utca 79", "06301234567", "Teszt1234&", "tesztelek@gmail.com");
        User expected = new User("4000 Balassagyarmat Híg utca 79", "teszt1234", "Teszt Elek", "Teszt1234&", "06301234567", "tesztelek@gmail.com");

        users = uDAO.getUserAll();

        Assertions.assertEquals(users.get(users.size() - 1).getAdress() ,expected.getAdress());

    }

    /*több adat módosítása, ebben az esetben password és address*/
    @Test
    void testModify2() throws Exception {
        users = uDAO.getUserAll();
        User.modify(users.get(users.size() - 1), "teszt1234","4000 Miskolc Híg utca 79", "06301234567", "Kispalimadár4321&#@", "tesztelek@gmail.com");
        User expected = new User("4000 Miskolc Híg utca 79", "teszt1234", "Teszt Elek", "Kispalimadár4321&#@", "06301234567", "tesztelek@gmail.com");

        users = uDAO.getUserAll();

        Assertions.assertEquals(users.get(users.size() - 1).getAdress(), expected.getAdress());

    }

    @Test
    void testRegister() throws Exception {
        users = uDAO.getUserAll();
        User.register("Teszt Elek", "teszt1234", "4000 Tesztváros Teszt utca 8", "06301234567", "Teszt1234&", "tesztelek@gmail.com");
        User expected = new User("4000 Tesztváros Teszt utca 8", "teszt1234", "Teszt Elek", "Teszt1234&", "06301234567", "tesztelek@gmail.com");

        users = uDAO.getUserAll();

        assertEquals(expected.getAdress(), users.get(users.size()-1).getAdress());
    }

    @Test
    void testSetName() {
        users = uDAO.getUserAll();
        User testu = users.get(users.size() - 1);
        testu.setName("Kis Kamilla");
        User expected = new User("4000 Tesztváros Teszt utca 8", "teszt1234", "Kis Kamilla", "Teszt1234&", "06301234567", "tesztelek@gmail.com");

        assertEquals(expected.getName(), users.get(users.size() - 1).getName());
    }

    @Test
    void testSetPhone() {
        users = uDAO.getUserAll();
        User testu = users.get(users.size()-1);
        testu.setPhone("06305671234");
        User expected = new User("4000 Tesztváros Teszt utca 8", "teszt1234", "Kis Kamilla", "Teszt1234&", "06305671234", "tesztelek@gmail.com");

        assertEquals(expected.getPhone(), users.get(users.size()-1).getPhone());
    }

    @Test
    void testSetPassword() {
        users = uDAO.getUserAll();
        User testu = users.get(users.size()-1);
        testu.setPassword("Kiskam0123#");
        User expected = new User("4000 Tesztváros Teszt utca 8", "teszt1234", "Kis Kamilla", "Kiskam0123#", "06305671234", "tesztelek@gmail.com");

        assertEquals(expected.getPassword(), users.get(users.size()-1).getPassword());
    }

    @Test
    void testSetUsername() {
        users = uDAO.getUserAll();
        User testu = users.get(users.size()-1);
        testu.setUsername("kiskamcsi");
        User expected = new User("4000 Tesztváros Teszt utca 8", "kiskamcsi", "Kis Kamilla", "Kiskam0123#", "06305671234", "tesztelek@gmail.com");

        assertEquals(expected.getUsername(), users.get(users.size()-1).getUsername());
    }

    @Test
    void testSetEmail() {
        users = uDAO.getUserAll();
        User testu = users.get(users.size()-1);
        testu.setEmail("kiskamil@gmail.com");
        User expected = new User("4000 Tesztváros Teszt utca 8", "kiskamcsi", "Kis Kamilla", "Kiskam0123#", "06305671234", "kiskamil@gmail.com");

        assertEquals(expected.getEmail(), users.get(users.size()-1).getEmail());
    }

    @Test
    void testsetAdress() {
        users = uDAO.getUserAll();
        User testu = users.get(users.size()-1);
        testu.setAdress("4000 Debrecen Hold utca 47");
        User expected = new User("4000 Debrecen Hold utca 47", "kiskamcsi", "Kis Kamilla", "Kiskam0123#", "06305671234", "kiskamil@gmail.com");

        assertEquals(expected.getAdress(), users.get(users.size()-1).getAdress());
    }
}
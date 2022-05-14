package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaUserDAO implements UserDAO{

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveUser(User a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(User a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User a,User b) {

        User user = (User)entityManager.find(User.class,b.getId());
        entityManager.getTransaction().begin();
        user.setAdress(a.getAdress());
        user.setEmail(a.getEmail());
        user.setPassword(a.getPassword());
        user.setPhone(a.getPhone());
        user.setUsername(a.getUsername());
        entityManager.getTransaction().commit();

    }

    @Override
    public List<User> getUser() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT a FROM USER a", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User getUserbyID(int id) {
        String sqlstr="SELECT user FROM User user WHERE ID="+"'"+id+"'";
        TypedQuery<User> query=entityManager.createQuery(sqlstr,User.class);
        return query.getSingleResult();
    }

    @Override
    public List<User> getUserAll() {
        String sqlstr = "SELECT user FROM User user";
        TypedQuery<User> query = entityManager.createQuery(sqlstr, User.class);
        return query.getResultList();
    }
    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}


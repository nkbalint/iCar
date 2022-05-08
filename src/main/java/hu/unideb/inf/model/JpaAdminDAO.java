package hu.unideb.inf.model;

import javax.persistence.*;
import java.util.List;
public class JpaAdminDAO implements   AdminDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveAdmin(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAdmin(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.remove(admin);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateAdmin(Admin admin) {
        saveAdmin(admin);
    }

    @Override
    public List<Admin> getAdminsAll() {
        String sqlstr="SELECT admin FROM Admin admin";
        TypedQuery<Admin> query=entityManager.createQuery(sqlstr,Admin.class);
        return query.getResultList();
    }

    @Override
    public Admin getAdminbyName(String name) {
        String sqlstr="SELECT admin FROM Admin admin WHERE NAME="+"'"+name+"'";
        TypedQuery<Admin> query=entityManager.createQuery(sqlstr,Admin.class);
        return query.getSingleResult();
    }

    @Override
    public List<Admin> getAdminsbyName(String name) {
        String sqlstr="SELECT admin FROM Admin admin WHERE NAME="+"'"+name+"'";
        TypedQuery<Admin> query=entityManager.createQuery(sqlstr,Admin.class);
        return query.getResultList();
    }

    @Override
    public Admin getAdminbyID(int id) {
        String sqlstr="SELECT admin FROM Admin admin WHERE ID="+"'"+id+"'";
        TypedQuery<Admin> query=entityManager.createQuery(sqlstr,Admin.class);
        return query.getSingleResult();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}

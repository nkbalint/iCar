package hu.unideb.inf.model;

import java.util.List;

public interface UserDAO extends AutoCloseable {
    //CRUD methods
    public void saveUser(User a); //C

    public void deleteUser(User a); //D

    public void updateUser(User a, User b); //U

    public List<User> getUser(); //R

    public  List<User> getUserAll();

    public User getUserbyID(int id);
}

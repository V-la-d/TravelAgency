package ua.repository;

import ua.model.User;

import java.util.List;

public interface UserDao {
    User findByName(String string);
    List<User> allUserAndOrders();
}

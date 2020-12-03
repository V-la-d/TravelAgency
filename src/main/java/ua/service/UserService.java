package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.model.User;
import ua.repository.UserDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public User findByName(String string) {
        return userDao.findByName(string);
    }


    public List<User> allUserAndOrders() {
        return userDao.allUserAndOrders();
    }
}

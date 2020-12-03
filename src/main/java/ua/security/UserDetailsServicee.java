package ua.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.model.User;
import ua.repository.UserDao;
import ua.security.SecurityUser;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("myUserService")
public class UserDetailsServicee implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServicee(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User user = userDao.findByName(string);
        if (user.equals(null)) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return SecurityUser.fromUser(user);
        }


    }

}

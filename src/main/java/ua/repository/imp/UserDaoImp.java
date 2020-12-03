package ua.repository.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.model.User;
import ua.repository.UserDao;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByName(String string) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.createQuery("from User u where u.name=:name")
                .setParameter("name", string).getSingleResult();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUserAndOrders() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select distinct r from User r,Booking b inner join r.bookings inner join b.room")
                .getResultList();

    }
}

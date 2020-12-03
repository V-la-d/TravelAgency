package ua.repository.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.model.Booking;
import ua.model.BookingRoom;
import ua.model.Room;
import ua.repository.RoomDao;

import java.util.List;

@Repository
public class RoomDaoImp implements RoomDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public RoomDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> saveRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
        return session.createQuery("from Room r where r.hotel.id=:id")
                .setParameter("id", room.getHotel().getId())
                .getResultList();
    }

    @Override
    public Room findById(Integer integer) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Room.class, integer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> updateRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.update(room);
        return session.createQuery("from Room r where r.hotel.id=:id")
                .setParameter("id", room.getHotel().getId())
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> deleteRoom(Integer integer) {
        Session session = sessionFactory.getCurrentSession();
        Room room = session.get(Room.class, integer);
        session.delete(room);
        return session.createQuery("from Room r where r.hotel.id=:id")
                .setParameter("id", room.getHotel().getId())
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> allHotelRooms(Integer integer) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Room r where hotel.id=:id")
                .setParameter("id", integer)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Booking> availableRoomsInHotel() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Booking b where b.room.id=:id")
                .setParameter("id", BookingRoom.getRoomId()).getResultList();


    }

    @Override
    public void bookingRoom(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.save(booking);
    }
}

package hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.User2;
import hibernate.util.HibernateUtil2;

public class UserDao2 {

    public void saveUser(User2 user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil2.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean validate(String userName, String password) {

        Transaction transaction = null;
        User2 user = null;
        try (Session session = HibernateUtil2.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User2) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

}
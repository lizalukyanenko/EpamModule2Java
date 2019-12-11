package errorAndException.dao;

import errorAndException.hibernate.HibernateSessionFactoryUtil;
import errorAndException.models.Group;
import errorAndException.models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GroupDaoImpl implements GroupDao {
    @Override
    public Student findStudentById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    @Override
    public Group find(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Group.class, id);
    }

    @Override
    public void save(Group model) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(model);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Group model) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(model);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Group model) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(model);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Group> findAll() {
        List<Group> groups = (List<Group>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Group").list();
        return groups;
    }
}

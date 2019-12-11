package errorAndException.services;

import errorAndException.dao.GroupDaoImpl;
import errorAndException.models.Group;
import errorAndException.models.Student;

import java.util.List;

public class GroupService {

    private GroupDaoImpl groupDao = new GroupDaoImpl();

    public GroupService() {
    }

    public Group find(Integer id) {
        return groupDao.find(id);
    }

    public void save(Group group) {
        groupDao.save(group);
    }

    public void delete(Group group) {
        groupDao.delete(group);
    }

    public void update(Group group) {
        groupDao.update(group);
    }

    public List<Group> findAll() {
        return groupDao.findAll();
    }

    public Student findStudentById(Integer id) {
        return groupDao.findStudentById(id);
    }
}

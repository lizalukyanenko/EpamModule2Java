package errorAndException.dao;

import errorAndException.models.Group;
import errorAndException.models.Student;

import java.util.Optional;

public interface GroupDao extends CrudDao<Group> {
    Student findStudentById(Integer id);
}

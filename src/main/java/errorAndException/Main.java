package errorAndException;

import errorAndException.models.Group;
import errorAndException.models.Student;
import errorAndException.services.GroupService;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GroupService groupService = new GroupService();
        Group group = new Group(1,"28tp");
        groupService.save(group);
        Student student = new Student("Nik", "Lukyanenko");
        student.setGroup(group);
        group.addStudent(student);
        Student student1 = new Student("Liza", "Marmysh");
        student1.setGroup(group);
        group.addStudent(student1);
        groupService.update(group);
    }
}

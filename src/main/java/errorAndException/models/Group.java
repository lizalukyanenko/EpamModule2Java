package errorAndException.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nameOfGroup;
//    ArrayList<Subject> subjects;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    ArrayList<Student> students;

    public Group() {
    }

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group(Integer id, String nameOfGroup) {
        this.id = id;
        this.nameOfGroup = nameOfGroup;
    }

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Integer getId() {
        return id;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "models.Group{" +
                "id Group =" + id +
                ", name of Group ='" + nameOfGroup +
                '}';
    }
}

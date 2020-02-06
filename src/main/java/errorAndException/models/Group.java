package errorAndException.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    Integer id;
    @Column(name = "group_name")
    String nameOfGroup;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Student> students;

    public Group() {
    }

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
        students = new ArrayList<>();
    }

    public Group(Integer id, String nameOfGroup) {
        this.id = id;
        this.nameOfGroup = nameOfGroup;
        students = new ArrayList<>();
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

    public List<Student> getStudents() {
        return students;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public void setStudents(List<Student> students) {
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

package errorAndException.models;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String surname;
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "models.Student{" +
                "id Student =" + id +
                ", name ='" + name +
                ", surname ='" + surname +
                '}';
    }
}

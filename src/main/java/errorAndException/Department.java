package errorAndException;

import errorAndException.models.Group;

import java.util.ArrayList;

public class Department {
    String nameOfDepartment;
    ArrayList<Group> groups;

    public Department(String nameOfDepartment, ArrayList<Group> groups) {
        this.nameOfDepartment = nameOfDepartment;
        this.groups = groups;
    }
}

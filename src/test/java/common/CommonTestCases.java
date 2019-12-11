package common;

import errorAndException.*;
import errorAndException.models.Group;
import errorAndException.models.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class CommonTestCases {

    private Department department;
    private ArrayList<Group> groups;
    private Student student;
    private ArrayList<Progress> progresses;
    private Subject subject;

    @Before
    public void setUp() {

//        department = new Department();
//        progresses = new ArrayList<>();
//        progresses.add(new Progress(1, new Student("Вася", "Иванов", 1), new Subject(1, "Math"), 1));
//        progresses.add(new Progress(1, new Student("Петя", "Иванов", 1), new Subject(1, "Math"), 1));
    }

    @Test
    public void checkMarkInGivenRangeSuccess() {
        Progress progress = progresses.get(0);
        assertTrue(progress.getMark() >= 1 && progress.getMark() <=10);
    }
}

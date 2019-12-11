package errorAndException;

import errorAndException.models.Student;

public class Progress {
    int idProgress;
    Student student;;
    Subject subject;
    int mark;

    public Progress(int idProgress, Student student, Subject subject, int mark) {
        if ((mark >= 0) && (mark < 11)) {
            this.idProgress = idProgress;
            this.student = student;
            this.subject = subject;
            this.mark = mark;
        }
    }

    public int getIdProgress() {
        return idProgress;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }
}

package Task3;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brianmcveigh on 4/5/16.
 */
public class StudentGenerator {
    private List<Student> students;

    public static final double HIGHEST_POSSIBLE_GPA = 4.0;
    public static final double LOWEST_POSSIBLE_GPA = 0.0;

    public StudentGenerator() {
        students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentWithHighestGPA() {
        double highestGPA = 0.0;
        Student valedictorian = new Student();
        for (Student student : students) {
            double gpa = student.getGpa();

            if (gpa > highestGPA) {
                highestGPA = gpa;
                valedictorian = student;
            }
        }
        return valedictorian;
    }

    public Student getStudentWithLowestGPA() {
        double highestPossibleGPA = HIGHEST_POSSIBLE_GPA;
        Student slacker = new Student();
        for (Student student : students) {
            double gpa = student.getGpa();

            if (gpa < highestPossibleGPA) {
                slacker = student;
            }
        }
        return slacker;
    }

    public boolean validateGPA(double gpa) {
        if (gpa >= LOWEST_POSSIBLE_GPA && gpa <= 4.0) {
            return true;
        }
        return false;
    }

    public double getAverageGPA() {
        int denominator = students.size();

        double numerator = 0.0;
        for (Student student : students) {
            numerator += student.getGpa();
        }

        return numerator / denominator;
    }
}

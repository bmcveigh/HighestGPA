import javax.swing.*;

/**
 * Created by brianmcveigh on 4/5/16.
 */
public class HighestGPAApp {
    public static void main(String[] args) {
        boolean done = false;
        StudentFactory sf = new StudentFactory();
        do {
            double gpa = 0.0;
            String name = JOptionPane.showInputDialog("Enter the student's name.");
            while (true) {
                gpa = Double.parseDouble(JOptionPane.showInputDialog("Enter " + name + "'s GPA"));

                if (!sf.validateGPA(gpa)) {
                    JOptionPane.showMessageDialog(null, "Invalid GPA. Try again.");
                    continue;
                }
                break;
            }
            Student student = new Student();
            student.setName(name);
            student.setGpa(gpa);
            sf.addStudent(student);

            int moreStudent = JOptionPane.showConfirmDialog(null, "Add another student?", "Select an Option", JOptionPane.YES_NO_CANCEL_OPTION);

            if (moreStudent == JOptionPane.NO_OPTION || moreStudent == JOptionPane.CANCEL_OPTION) {
                break;
            }
        } while (!done);

        Student valedictorian = sf.getStudentWithHighestGPA();
        Student slacker = sf.getStudentWithLowestGPA();
        String output = "The student with the highest GPA's name is: " + valedictorian.getName() + ", with a GPA of " + valedictorian.getGpa() + "\n";
        output += "The student with the lowest GPA's name is: " + slacker.getName() + ", with a GPA of " + slacker.getGpa() + "\n";
        output += "The average GPA is: " + sf.getAverageGPA() + "\n";
        JOptionPane.showMessageDialog(null, output);

        int reportChoice = JOptionPane.showConfirmDialog(null, "Would you like to see a report?");

        if (reportChoice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, sf.generateReport());
        }
    }
}

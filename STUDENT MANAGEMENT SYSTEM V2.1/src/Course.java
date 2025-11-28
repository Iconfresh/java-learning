import java.io.Serializable;
/**
 * Course represents a course taken by a student.
 * Now includes creditUnits for weighted GPA calculation.
 * */

public class Course {
    private static final long serialVersionUID = 1L;

    private String courseName;
    private String courseCode;
    private double score;  // -1 means not yet set
    private String grade;  // A,B,C,D,F
    private int creditUnits;  // credit units ( eg. 2, 3, 4, 6)


    public Course(String courseName, String courseCode, int creditUnits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.score = -1;
        this.grade = "N/A";
        this.creditUnits = creditUnits;
    }

    // Set score and update grade
    public void setScore(double score) {
        this.score = score;
        this.grade = calculateGrade(score);
    }

    private String calculateGrade(double score) {
        if (score >= 70) return "A";
        else if (score >= 60) return "B";
        else if (score >= 50) return "C";
        else if (score >= 45) return "D";
        else return "F";
    }

    //Grade points for weighted GPA (A=5, .. F=0)
    public int getGradePoint() {
        switch (grade) {
            case "A": return 5;
            case "B": return 4;
            case "C": return 3;
            case "D": return 2;
            default: return 0;
        }
    }

    public String getCourseName() { return courseName;}
    public String getCourseCode() { return courseCode;}
    public double getScore() { return score;}
    public String getGrade() { return grade;}
    public int getCreditUnits() { return creditUnits;}

    public void setCourseName(String name) { this.courseName = name;}
    public void setCourseCode(String code) { this.courseCode = code;}
    public void setCreditUnits(int units) { this.creditUnits = units;}

    public void showCourse() {
        System.out.printf("%s - %s | Units: %d | Score: %s | Grade: %s%n",
                courseCode,
                courseName,
                creditUnits,
                (score < 0 ? "N/A" : String.valueOf(score)),
                grade
        );
    }
}

public class Course {
    private String courseName;
    private String courseCode;
    private double score;
    private String grade;

    // Constructor

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.score = -1;
        this.grade = "N/A";
    }

    // Update score and grade
    public void setScore(double score) {
        this.score = score;
        this.grade = calculateGrade(score);
    }
    // Grade logic
    private String calculateGrade(double score) {
        if (score >= 70) return "A";
        else if (score >= 60) return "B";
        else if (score >= 50) return "C";
        else if (score >= 45) return "D";
        else return "F";
    }

    // Getters
    public String getCourseName() { return courseName;}
    public String getCourseCode() { return courseCode;}
    public double getScore() { return score;}
    public String getGrade() { return grade;}

    // Display course details
    public void showCourse() {
        System.out.println(courseCode + " - " + courseName + " | Score: " + score + " | Grade: " + grade);
    }
}

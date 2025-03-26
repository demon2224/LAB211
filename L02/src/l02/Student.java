/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02;

/**
 * LO2 - Create a Java console program to manage students.
 *
 * @author TUANLEACE180905
 */
public class Student {

    private String code;
    private String studentName;
    private String semester;
    private String courseName;

    /**
     * Default constructor for the Student class.
     */
    public Student() {
    }

    /**
     * Constructs a Student with specified code, name, semester, and course
     * name.
     *
     * @param code the student's code
     * @param studentName the name of the student
     * @param semester the semester in which the student is enrolled
     * @param courseName the name of the course
     */
    public Student(String code, String studentName, String semester, String courseName) {
        this.code = code;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Gets the student's code.
     *
     * @return the student's code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the student's code.
     *
     * @param code the new code for the student
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the student's name.
     *
     * @return the student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the student's name.
     *
     * @param studentName the new name for the student
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets the semester in which the student is enrolled.
     *
     * @return the semester number
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester for the student.
     *
     * @param semester the new semester number
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Gets the name of the course the student is enrolled in.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course for the student.
     *
     * @param courseName the new course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns a string representation of the student.
     *
     * @return a formatted string of student details
     */
    @Override
    public String toString() {
        return String.format("| %-12s | %-25s | %-8s | %-6s |\n", code, studentName, semester, courseName);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * LO2 - Create a Java console program to manage students.
 *
 * @author TUANLEACE180905
 */
public class StudentManagement {

    private ArrayList<Student> students;
    private ArrayList<Student> tmpStudents;
    private String info;

    /**
     * Constructs a new StudentManagement instance.
     */
    public StudentManagement() {
        this.students = new ArrayList<>();
        this.tmpStudents = new ArrayList<>();
    }

    /**
     * Gets the list of all students.
     *
     * @return an ArrayList of students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Gets the temporary list of students.
     *
     * @return an ArrayList of temporary students
     */
    public ArrayList<Student> getTmpStudents() {
        return tmpStudents;
    }

    /**
     * Gets additional information about the current operation.
     *
     * @return a string containing operation information
     */
    public String getInfo() {
        return info;
    }

    /**
     * Checks if a student code exists in the student list.
     *
     * @param code the student code to check
     * @return true if the code exists, false otherwise
     */
    public boolean isCodeExist(String code) {
        for (Student student : students) {
            if (student.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a student is enrolled in a specific course for a given
     * semester.
     *
     * @param code the student code
     * @param semester the semester
     * @param course the course name
     * @return true if the student is enrolled, false otherwise
     */
    public boolean isCourseExist(String code, String semester, String course) {
        for (Student student : students) {
            if (student.getCode().equals(code) && student.getSemester().equals(semester)
                    && student.getCourseName().equals(course)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the student name based on the student code.
     *
     * @param code the student code
     * @return the student's name, or null if not found
     */
    public String getStudentNameByCode(String code) {
        for (Student student : students) {
            if (student.getCode().equals(code)) {
                return student.getStudentName();
            }
        }
        return null;
    }

    /**
     * Counts the number of unique courses ("Java", ".Net", "C/C++") in a given
     * semester.
     *
     * @param semester The semester to check (e.g., "SP25", "SU23").
     * @return The number of unique courses (0 to 3).
     */
    public int countUniqueCoursesInSemester(String semester) {
        HashSet<String> uniqueCourses = new HashSet<>();
        for (Student student : students) {
            if (student.getSemester().equals(semester)) {
                String course = student.getCourseName();
                if (course.equals("Java") || course.equals(".Net") || course.equals("C/C++")) {
                    uniqueCourses.add(course);
                }
            }
        }
        return uniqueCourses.size();
    }

    /**
     * Finds and stores students by their code.
     *
     * @param code the student code to search for
     */
    public void findStudentsByCode(String code) {
        tmpStudents.clear();
        for (Student student : students) {
            if (student.getCode().equals(code)) {
                tmpStudents.add(student);
            }
        }
    }

    /**
     * Finds students whose ID or name contains the given search term and adds
     * them to tmpStudents.
     *
     * @param searchTerm the term to search for in ID or name
     */
    public void findStudentsByTerm(String searchTerm) {
        tmpStudents.clear();
        for (Student student : students) {
            if (student.getCode().toUpperCase().contains(searchTerm.toUpperCase())
                    || student.getStudentName().toUpperCase().contains(searchTerm.toUpperCase())) {
                tmpStudents.add(student);
            }
        }
    }

    /**
     * Sorts the temporary student list by student name in a case-insensitive
     * manner.
     */
    public void sortByName() {
        Collections.sort(tmpStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
            }
        });
    }

    /**
     * Updates the student name for all records with the given code.
     *
     * @param code the student code to update
     * @param newName the new student name
     */
    public void updateStudentNameByCode(String code, String newName) {
        for (Student student : students) {
            if (student.getCode().equalsIgnoreCase(code)) {
                student.setStudentName(newName);
            }
        }
        findStudentsByCode(code);
        displaySearchResult();
    }

    /**
     * Displays the results of a search operation on the console.
     */
    public void displaySearchResult() {
        String result = "";
        result += "+-----+--------------+---------------------------+----------+--------+\n";
        result += "| No. | Student ID   | Student name              | Semester | Course |\n";
        result += "+-----+--------------+---------------------------+----------+--------+\n";
        int no = 1;
        for (Student student : tmpStudents) {
            result += String.format("| %3d " + student.toString(), no++);
        }
        result += "+-----+--------------+---------------------------+----------+--------+\n";
        this.info = result;
    }

    /**
     * Displays all students in the list.
     */
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available to display.");
            this.info = "No students available to display.";
            return;
        }
        String result = "";
        result += "+-----+--------------+---------------------------+----------+--------+\n";
        result += "| No. | Student ID   | Student name              | Semester | Course |\n";
        result += "+-----+--------------+---------------------------+----------+--------+\n";
        int no = 1;
        for (Student student : students) {
            result += String.format("| %3d " + student.toString(), no++);
        }
        result += "+-----+--------------+---------------------------+----------+--------+\n";
        this.info = result;
    }

    /**
     * Generates a report of student enrollments and total course counts.
     */
    public void report() {
        String result = "";
        result += "+-----+--------------+---------------------------+--------+-----------------+\n";
        result += "| No. | Student ID   | Student name              | Course | Total of course |\n";
        result += "+-----+--------------+---------------------------+--------+-----------------+\n";
        HashMap<String, Integer> totalCourse = new HashMap<>();
        int no = 1;
        for (Student student : students) {
            String key = student.getCode() + "-" + student.getCourseName();
            totalCourse.put(key, totalCourse.getOrDefault(key, 0) + 1);
        }

        HashMap<String, Integer> processedKeys = new HashMap<>();
        for (Student student : students) {
            String key = student.getCode() + "-" + student.getCourseName();
            if (!processedKeys.containsKey(key)) {
                result += String.format("| %3d | %-12s | %-25s | %-6s | %15d |\n",
                        no++, student.getCode(), student.getStudentName(), student.getCourseName(),
                        totalCourse.get(key));
                processedKeys.put(key, totalCourse.get(key));
            }
        }
        result += "+-----+--------------+---------------------------+--------+-----------------+\n";
        this.info = result;
    }

    /**
     * Populates the student list with sample data.
     */
    public void studentList() {
        students.add(new Student("CE180001", "Le Van A", "SP25", "Java"));
        students.add(new Student("CE180001", "Le Van A", "SP25", ".Net"));
        students.add(new Student("CE180001", "Le Van A", "SP25", "C/C++"));
        students.add(new Student("CE180001", "Le Van A", "FA24", ".Net"));
        students.add(new Student("CE180001", "Le Van A", "SU24", "Java"));
        students.add(new Student("CE180002", "Tran Thi B", "SP25", "Java"));
        students.add(new Student("CE180002", "Tran Thi B", "FA24", "Java"));
        students.add(new Student("CE180003", "Ngo Van C", "SP25", "C/C++"));
        students.add(new Student("CE180004", "Dang Van D", "SP25", "Java"));
        students.add(new Student("CE180005", "Dang Van D", "SP25", "Java"));
    }

    /**
     * Creates a new student and adds to the list.
     */
    public void createStudent() {
        String continueChoice;
        do {
            String code = MyLib.getValidID("Enter student ID: ", 8);
            String name;
            if (!isCodeExist(code)) {
                name = MyLib.getValidName("Enter student name: ",
                        "Invalid name! Please enter at least 2 words, letters only, length 3-25.", 3, 25);
            } else {
                name = getStudentNameByCode(code);
                System.out.println("Student name: " + name);
            }
            String semester;
            int studentCourseCount;
            do {
                semester = MyLib.getValidSemester("Enter semester: ", 4);
                studentCourseCount = 0;
                for (Student student : students) {
                    if (student.getCode().equals(code) && student.getSemester().equals(semester)) {
                        studentCourseCount++;
                    }
                }
                if (studentCourseCount >= 3) {
                    System.out.println("Student " + code + " has already registered 3 courses in semester " + semester + ". Please enter a different semester.");
                }
            } while (studentCourseCount >= 3);

            String course;
            do {
                course = MyLib.getValidCourse("Enter course (Java, .Net, C/C++): ");
                if (isCourseExist(code, semester, course)) {
                    System.out.println("Students are not allowed to take 2 " + course + " courses in 1 semester.");
                }
            } while (isCourseExist(code, semester, course));

            if (students.size() >= 10) {
                if (!MyLib.getValidYesNo("Do you want to order now (Y/N)?",
                        "Invalid input. Please enter 'Y' or 'N'.").equalsIgnoreCase("Y")) {
                    break;
                }
            }
            students.add(new Student(code, name, semester, course));
            System.out.println("--> Student created successfully.");
            displayAllStudents();
            System.out.println(getInfo());

            continueChoice = MyLib.getValidYesNo("Do you want to continue adding another student? (Y/N): ",
                    "Invalid input. Please enter 'Y' or 'N'.");
        } while (continueChoice.equalsIgnoreCase("Y"));
    }

    /**
     * Searches and sorts students by ID or name.
     */
    public void findAndSort() {
        while (true) {
            if (students.isEmpty()) {
                System.out.println("The student list is empty. Cannot perform search.");
                return;
            }
            tmpStudents.clear();
            String searchTerm = MyLib.getValidSearchTerm("Enter part of ID or Name to search: ",
                    "Invalid input! Search term must be non-empty, max 25 characters (e.g., CE180905 or Le).");
            findStudentsByTerm(searchTerm);
            if (tmpStudents.isEmpty()) {
                System.out.println("No students found with the given criteria.");
                return;
            }
            sortByName();
            displaySearchResult();
            System.out.println("Search Results: ");
            System.out.println(getInfo());
            String answer = MyLib.getValidYesNo("Do you want to continue searching? (Y/N): ",
                    "Invalid input. Please enter 'Y' or 'N'.");
            if (!answer.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    /**
     * Updates or deletes a student record based on user choice.
     */
    public void updateOrDelete() {
        if (students.isEmpty()) {
            System.out.println("The student list is empty. Cannot perform update or delete.");
            return;
        }
        System.out.println("List of all students available for update/delete:");
        displayAllStudents();
        System.out.println(getInfo());
        String code = MyLib.getValidID("Enter student ID to update/delete: ", 8);
        if (!isCodeExist(code)) {
            System.out.println("Student with ID " + code + " not found.");
            return;
        }
        findStudentsByCode(code);
        System.out.println("Records for Student ID " + code + ":");
        displaySearchResult();
        System.out.println(getInfo());

        String choice = MyLib.getValidUpdateOrDelete("Do you want to update (U) or delete (D) the student? ",
                "Invalid input. Please choose U or D.");
        if (choice.equalsIgnoreCase("U")) {
            updateStudent(code);
        } else if (choice.equalsIgnoreCase("D")) {
            deleteStudentRecord(code);
        }
    }

    /**
     * Updates a student's information.
     *
     * @param code the student code to update
     */
    private void updateStudent(String code) {
        String oldName = getStudentNameByCode(code);
        String newName = oldName;
        String keepName;
        do {
            keepName = MyLib.getValidYesNo("Do you want to keep the old name '" + oldName + "'? (Y/N): ",
                    "Invalid input. Please enter 'Y' or 'N'.");
            if (!keepName.equalsIgnoreCase("Y") && !keepName.equalsIgnoreCase("N")) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (!keepName.equalsIgnoreCase("Y") && !keepName.equalsIgnoreCase("N"));
        if (keepName.equalsIgnoreCase("N")) {
            do {
                newName = MyLib.getValidName("Enter student new name: ",
                        "Invalid name! Please enter at least 2 words, letters only, length 3-25", 3, 25);
                if (newName == null || newName.isEmpty()) {
                    System.out.println("Name cannot be empty. Please try again.");
                }
            } while (newName == null || newName.isEmpty());
        }
        updateStudentNameByCode(code, newName);

        int semesterCount = 0;
        String[] semesters = new String[tmpStudents.size()];
        for (Student student : tmpStudents) {
            if (student.getCode().equalsIgnoreCase(code)) {
                boolean isNew = true;
                for (int i = 0; i < semesterCount; i++) {
                    if (semesters[i] != null && semesters[i].equals(student.getSemester())) {
                        isNew = false;
                        break;
                    }
                }
                if (isNew) {
                    semesters[semesterCount++] = student.getSemester();
                }
            }
        }
        if (semesterCount == 0) {
            System.out.println("No semesters found for student ID " + code + ". Please add a semester first.");
            return;
        }
        System.out.println("Available semesters for " + code + ":");
        for (int i = 0; i < semesterCount; i++) {
            System.out.println((i + 1) + ". " + semesters[i]);
        }
        int semesterIndex;
        do {
            semesterIndex = MyLib.getInt("Select semester to update (1 to " + semesterCount + "): ",
                    "Invalid input! Please enter a valid number.", 1, semesterCount) - 1;
            if (semesterIndex < 0 || semesterIndex >= semesterCount) {
                System.out.println("Invalid semester selection. Please try again.");
            }
        } while (semesterIndex < 0 || semesterIndex >= semesterCount);
        String oldSemester = semesters[semesterIndex];

        String newSemester = oldSemester;
        String keepSemester;
        do {
            keepSemester = MyLib.getValidYesNo("Do you want to keep the old semester '" + oldSemester + "'? (Y/N): ",
                    "Invalid input. Please enter 'Y' or 'N'.");
            if (!keepSemester.equalsIgnoreCase("Y") && !keepSemester.equalsIgnoreCase("N")) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (!keepSemester.equalsIgnoreCase("Y") && !keepSemester.equalsIgnoreCase("N"));
        if (keepSemester.equalsIgnoreCase("N")) {
            int newCourseCount;
            do {
                newSemester = MyLib.getValidSemester("Enter new semester: ", 4);
                newCourseCount = 0;
                for (Student student : students) {
                    if (student.getCode().equalsIgnoreCase(code) && student.getSemester().equalsIgnoreCase(newSemester)) {
                        newCourseCount++;
                    }
                }
                if (newCourseCount >= 3) {
                    System.out.println("Student " + code + " has already registered 3 courses in semester " + newSemester + ". Please enter a different semester.");
                }
            } while (newCourseCount >= 3);
        }

        int courseCount = 0;
        String[] courses = new String[tmpStudents.size()];
        for (Student student : tmpStudents) {
            if (student.getCode().equalsIgnoreCase(code) && student.getSemester().equalsIgnoreCase(oldSemester)) {
                boolean isNew = true;
                for (int i = 0; i < courseCount; i++) {
                    if (courses[i] != null && courses[i].equals(student.getCourseName())) {
                        isNew = false;
                        break;
                    }
                }
                if (isNew) {
                    courses[courseCount++] = student.getCourseName();
                }
            }
        }
        if (courseCount == 0) {
            System.out.println("No courses found for semester " + oldSemester + " of student ID " + code + ". Please add a course first.");
            return;
        }
        System.out.println("Available courses for " + oldSemester + ":");
        for (int i = 0; i < courseCount; i++) {
            System.out.println((i + 1) + ". " + courses[i]);
        }
        int courseIndex;
        do {
            courseIndex = MyLib.getInt("Select course to update (1 to " + courseCount + "): ",
                    "Invalid input! Please enter a valid number.", 1, courseCount) - 1;
            if (courseIndex < 0 || courseIndex >= courseCount) {
                System.out.println("Invalid course selection. Please try again.");
            }
        } while (courseIndex < 0 || courseIndex >= courseCount);
        String oldCourse = courses[courseIndex];
        String newCourse = oldCourse;
        String keepCourse;
        do {
            keepCourse = MyLib.getValidYesNo("Do you want to keep the old course '" + oldCourse + "'? (Y/N): ",
                    "Invalid input! Please enter 'Y' or 'N'.");
            if (!keepCourse.equalsIgnoreCase("Y") && !keepCourse.equalsIgnoreCase("N")) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (!keepCourse.equalsIgnoreCase("Y") && !keepCourse.equalsIgnoreCase("N"));
        if (keepCourse.equalsIgnoreCase("N")) {
            boolean courseUpdated = false;
            do {
                newCourse = MyLib.getValidCourse("Enter new course: ");
                boolean courseExistsInRecord = false;
                for (Student student : students) {
                    if (student.getCode().equalsIgnoreCase(code) && student.getSemester().equalsIgnoreCase(newSemester)
                            && student.getCourseName().equalsIgnoreCase(newCourse) && !student.getCourseName().equalsIgnoreCase(oldCourse)) {
                        courseExistsInRecord = true;
                        break;
                    }
                }
                if (courseExistsInRecord) {
                    System.out.println("Students are not allowed to take 2 " + newCourse + " courses in semester " + newSemester + ".");
                } else {
                    courseUpdated = true;
                }
            } while (!courseUpdated);
        }

        boolean willCauseDuplicate = false;
        for (Student student : students) {
            if (student.getCode().equalsIgnoreCase(code)
                    && student.getSemester().equalsIgnoreCase(newSemester)
                    && student.getCourseName().equalsIgnoreCase(newCourse)
                    && !(student.getSemester().equalsIgnoreCase(oldSemester) && student.getCourseName().equalsIgnoreCase(oldCourse))) {
                willCauseDuplicate = true;
                break;
            }
        }
        if (willCauseDuplicate) {
            System.out.println("Cannot update! The student " + code + " already has the course " + newCourse
                    + " in semester " + newSemester + ". Please choose a different semester or course.");
            return; 
        }

        for (Student student : students) {
            if (student.getCode().equalsIgnoreCase(code) && student.getSemester().equalsIgnoreCase(oldSemester)
                    && student.getCourseName().equalsIgnoreCase(oldCourse)) {
                student.setSemester(newSemester);
                student.setCourseName(newCourse);
            }
        }
        displaySearchResult();
        System.out.println("--> Update successful.");
        System.out.println(getInfo());
    }

    /**
     * Deletes a specific student record.
     *
     * @param code the student code to delete
     */
    private void deleteStudentRecord(String code) {
        if (tmpStudents.isEmpty()) {
            System.out.println("No records found for student ID " + code + ".");
            return;
        }
        int recordCount = tmpStudents.size();
        int recordIndex = MyLib.getInt("Select record number to delete (1 to " + recordCount + "): ",
                "Invalid input! Please enter a valid number.", 1, recordCount) - 1;
        Student recordToDelete = tmpStudents.get(recordIndex);
        if (MyLib.getValidYesNo("Are you sure you want to delete this record? (Y/N): ",
                "Invalid input. Please enter 'Y' or 'N'.").equalsIgnoreCase("Y")) {
            students.removeIf(student
                    -> student.getCode().equalsIgnoreCase(recordToDelete.getCode())
                    && student.getSemester().equalsIgnoreCase(recordToDelete.getSemester())
                    && student.getCourseName().equalsIgnoreCase(recordToDelete.getCourseName()));
            findStudentsByCode(code);
            System.out.println("Record deleted successfully.");
            System.out.println("List after deletion as requested by Student ID " + code + ":");
            displayAllStudents();
            System.out.println(getInfo());
        } else {
            System.out.println("--> Deletion canceled.");
        }
    }

    /**
     * Generates and displays a report of student enrollments.
     */
    public void generateReport() {
        if (students.isEmpty()) {
            System.out.println("The student list is empty. Cannot generate report.");
            return;
        }
        report();
        System.out.println(getInfo());
    }

    /**
     * Adds a predefined list of students.
     */
    public void addStudentList() {
        System.out.println("Students imported successfully!");
        studentList();
    }
}

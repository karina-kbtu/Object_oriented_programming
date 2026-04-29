package oop_project;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String name;
    private int credits;
    private List<Lesson> lessons = new ArrayList<>();
    private List<Teacher> instructors = new ArrayList<>();
    private int year;
    private String major;
    private List<Student> enrolledStudents;

    public Course(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.instructors = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
 

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
    public void addInstructor(Teacher teacher) {
        instructors.add(teacher);
    }
    public List<Lesson> getLessons() {
        return new ArrayList<>(lessons);
    }
    public List<Teacher> getInstructors() {
        return new ArrayList<>(instructors);
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    public void addEnrolledStudent(Student student) {
        enrolledStudents.add(student);
    }
    public boolean isAvailableForYear(int year) {
        return this.year == year;
    }
    public String toString() {
        return String.format("Course{code='%s', name='%s', credits=%d}", code, name, credits);
    }
}

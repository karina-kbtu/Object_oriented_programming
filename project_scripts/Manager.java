package oop_project;
import java.util.Comparator;
import java.util.List;

public class Manager extends Employee{
private static final long serialVersionUID = 1L;
private ManagerType type;

public Manager(String id, String name, String email,String password) {
    super(id, name, email,password);
    this.type = ManagerType.OR;
}
public void update(News news) {
    System.out.println("Manager received news: " + news.getTopic());
}
public void sendMessage(Message message) {
    System.out.println("Message sent by " + getName() + " to " + message.getReceiverEmail());
    System.out.println("Content: " + message.getContent());
}
public void publishNews(String topic, String content, NewsPublisher publisher) {
    News news = new News(topic, content, false);
    publisher.publishNews(news);
    System.out.println("News published: " + news.getTopic());
}

public void viewInfo(List<Student> students, List<Teacher> teachers, Comparator<User> comparator) {
    System.out.println("Viewing information about students:");
    students.stream().sorted(comparator).forEach(student ->
            System.out.println("Student: " + student.getName() + ", GPA: " + student.getGPA()));
    System.out.println("\nViewing information about teachers:");
    teachers.stream().sorted(comparator).forEach(teacher ->
            System.out.println("Teacher: " + teacher.getName() + ", Avg Rating: " + teacher.getAverageRating()));
}

public void addCourseForRegistration(Course course, int year, String major) {
    course.setYear(year);
    course.setMajor(major);
    System.out.println("Course " + course.getName() + " added for year " + year + ", major " + major);
}
public void assignCourseToTeacher(Course course, Teacher teacher) {
    course.addInstructor(teacher);
    teacher.assignCourse(course);
    System.out.println("Assigned course " + course.getName() + " to teacher " + teacher.getName());
}
public void approveStudentRegistration(Student student, Course course) {
    if (!course.isAvailableForYear(student.getYear())) {
        System.out.println("Course " + course.getName() + " is not available for year " + student.getYear());
        return;
    }
    student.registerForCourse(course);
    System.out.println("Student " + student.getName() + " registered for course " + course.getName());
}
public void viewTeacherRating(Teacher teacher) {
    System.out.println("Average rating for " + teacher.getName() + ": " + teacher.getAverageRating());
}
public void generatePerformanceReport(List<Student> students) {
    System.out.println("Generating performance report...");
    for (Student student : students) {
        System.out.println("Student: " + student.getName());
        System.out.println("GPA: " + student.getGPA());
        System.out.println("Enrolled Courses: " + student.getEnrolledCourses());
    }
}
public void performDuties() {
    System.out.println("Performing managerial duties.");
}
public void displayRole() {
    System.out.println("Role: Manager (" + type + ")");
}
}


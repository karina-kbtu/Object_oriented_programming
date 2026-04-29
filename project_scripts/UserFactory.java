package oop_project;



public class UserFactory {

    public static User createUser(String role, String id, String name, String email, String password,int year) {
        return switch (role.toLowerCase()) {
            case "student" -> new Student(id, name, email, year, password);
            case "teacher" -> new Teacher(id, name, email,password);
            case "admin" -> new Admin(id, name, email,password);
            case "manager" -> new Manager(id, name, email,password);
            default -> throw new IllegalArgumentException("Invalid user type: " + role);
        };
    }
}

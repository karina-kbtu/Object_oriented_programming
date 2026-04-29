package oop_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Admin extends Employee {
    
	private static final long serialVersionUID = 1L;
	private Map<String, User> users = new HashMap<>();

    public Admin(String id, String name, String email,String password) {
        super(id, name, email,password);
    }
    public void addUser(User user) {
        users.put(user.getId(), user);
    }
    public void updateUser(String userId, String newName, String newEmail) {
        User user = users.get(userId);
        if (user != null) {
            System.out.printf("User %s updated.%n", userId);
        }
    }
    public void removeUser(String userId) {
        users.remove(userId);
        System.out.printf("User %s removed.%n", userId);
    }
    public void viewLogs(String userId) {
    	  try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\eclipse-workspace\\oop_project\\src\\oop_project\\users.txt"))) {
    	        String line;
    	        boolean found = false;

    	        while ((line = reader.readLine()) != null) {
    	            String[] parts = line.split(",");
    	            if (parts[0].equals(userId)) {
    	                System.out.println("User Information:");
    	                System.out.println("ID: " + parts[0]);
    	                System.out.println("Name: " + parts[1]);
    	                System.out.println("Email: " + parts[2]);
    	                System.out.println("Password: " + parts[3]);
    	                System.out.println("Role: " + parts[4]);
    	                found = true;
    	                break;
    	            }
    	        }

    	        if (!found) {
    	            System.out.println("No user found with ID: " + userId);
    	        }
    	    } catch (IOException e) {
    	        System.err.println("Error reading user logs: " + e.getMessage());
    	    }
    }
    public void update(News news) {
        System.out.println("Teacher received news: " + news.getTopic());
    }
    public void sendMessage(Message message) {
        System.out.println("Message sent by " + getName() + " to " + message.getReceiverEmail());
        System.out.println("Content: " + message.getContent());
    }
    public void performDuties() {
        System.out.println("System administration duties.");
    }
    public void displayRole() {
        System.out.println("Role: Admin");
    }
}



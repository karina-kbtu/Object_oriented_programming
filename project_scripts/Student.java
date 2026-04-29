package oop_project;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
public class Student extends User implements Observer, Researcher {
    
	private static final long serialVersionUID = 1L;
	private int year;
    private double gpa;
    private List<Course> enrolledCourses;
    private List<Mark> marks;

    public Student(String id, String name, String email, int year,String password) {
        super(id, name, email,password);
        this.year = year;
        this.enrolledCourses = new ArrayList<>();
        this.marks = new ArrayList<>();
    }
    public void update(News news) {
        System.out.println("Student received news: " + news.getTopic());
    }
    public void sendMessage(Message message) {
        System.out.println("Message sent by " + getName() + " to " + message.getReceiverEmail());
        System.out.println("Content: " + message.getContent());
    }
    public void rateTeacher(Teacher teacher, int rating) {
        teacher.addRating(rating); 
        System.out.println(getName() + " rated " + teacher.getName() + " with " + rating + " points.");
    }
    public void registerForCourse(Course course) {
        if (!course.isAvailableForYear(year)) {
            System.out.println("Course " + course.getName() + " is not available for your year.");
            return;
        }
        enrolledCourses.add(course);
        course.addEnrolledStudent(this);
        System.out.println("Registered for course: " + course.getName());
    }

    public void viewTranscript() {
    	File transcriptFile = new File("C:\\Users\\Admin\\eclipse-workspace\\oop_project\\src\\oop_project\\transcript.txt");
    	 if (transcriptFile.exists()) {
    	        try {
    	            BufferedReader reader = new BufferedReader(new FileReader(transcriptFile));
    	            String line;
    	            System.out.println("Transcript:");
    	            while ((line = reader.readLine()) != null) {
    	                System.out.println(line);
    	            }
    	            reader.close();
    	        } catch (IOException e) {
    	            System.err.println("Error reading transcript: " + e.getMessage());
    	        }
    	    } else {
    	        System.out.println("Transcript file not found: " + transcriptFile.getAbsolutePath());
    	    }
    }
    public void viewMarks() {
        System.out.println("Marks for " + getName() + ":");
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }
    public void addMark(Mark mark) {
        marks.add(mark);
        calculateGPA();
    }
    private void calculateGPA() {
        double totalScore = 0;
        for (Mark mark : marks) {
            totalScore += mark.getFinalScore();
        }
        this.gpa = marks.isEmpty() ? 0 : totalScore / marks.size();
    }
    public int getYear() {
        return year;
    }
    public double getGPA() {
        return gpa;
    }
    public String getName() {
        return super.getName();
    }

    public String getId() {
        return super.getId();
    }
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public void displayRole() {
        System.out.println("Role: Student");
    }
	@Override
	public void addResearchPaper(ResearchPaper paper) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ResearchPaper> getResearchPapers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
}


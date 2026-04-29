package oop_project;

import java.util.Collections;
	import java.util.ArrayList;
	import java.util.List;

	public class Teacher extends Employee implements Researcher, Observer {
	    
		private static final long serialVersionUID = 1L;
		private List<Course> assignedCourses = new ArrayList<>();
	    private List<ResearchPaper> researchPapers = new ArrayList<>();
	    private List<Integer> ratings;
	    public Teacher(String id, String name, String email,String password) {
	        super(id, name, email,password);
	        this.ratings = new ArrayList<>();
	    }

	    public void assignCourse(Course course) {
	        assignedCourses.add(course);
	        System.out.println("Assigned course " + course.getName() + " to teacher " + getName());
	    }

	    public List<Course> viewCourses() {
	        return assignedCourses;
	    }

	    public void manageCourse(Course course, Lesson lesson) {
	    	 if (assignedCourses.contains(course)) {
	             course.addLesson(lesson);
	             System.out.println("Lesson added to course: " + course.getName());
	         } else {
	             System.out.println("You are not assigned to this course.");
	         }
	    }
	    public void addRating(int rating) {
	        if (rating < 0 || rating > 10) {
	            System.out.println("Rating must be between 0 and 10.");
	            return;
	        }
	        ratings.add(rating);
	        System.out.println("Rating " + rating + " added for teacher " + getName());
	    }
	    public List<Integer> getRatings() {
	        return ratings;
	    }
	    public double getAverageRating() {
	        if (ratings.isEmpty()) {
	            return 0.0;
	        }
	        double total = 0;
	        for (int rating : ratings) {
	            total += rating;
	        }
	        return total / ratings.size();
	    }

	    public void putMarks(Student student, Course course, Mark mark) {
	        if (!assignedCourses.contains(course)) {
	            System.out.println("You are not assigned to this course.");
	            return;
	        }
	        student.addMark(mark);
	        System.out.println("Mark assigned to " + student.getName() + " in course " + course.getName());
	    }
	    public void update(News news) {
	        System.out.println("Teacher received news: " + news.getTopic());
	    }
	    public void sendMessage(Message message) {
	        System.out.println("Message sent by " + getName() + " to " + message.getReceiverEmail());
	        System.out.println("Content: " + message.getContent());
	    }
	    public void sendComplaint(Student student, String complaint, UrgencyLevel level) {
	        System.out.printf("Complaint sent: %s, Level: %s%n", complaint, level);
	    }

	    public void addResearchPaper(ResearchPaper paper) {
	        researchPapers.add(paper);
	    }

	    public List<ResearchPaper> getResearchPapers() {
	        return new ArrayList<>(researchPapers);
	    }
	    public int calculateHIndex() {
	    	if (researchPapers == null || researchPapers.isEmpty()) return 0;  
	        List<Integer> citations = new ArrayList<>();
	        for (ResearchPaper paper : researchPapers) {
	            citations.add(paper.getCitations());  
	        }
	        Collections.sort(citations, Collections.reverseOrder());
	        
	        int hIndex = 0;
	       
	        for (int i = 0; i < citations.size(); i++) {
	            if (citations.get(i) >= i + 1) {
	                hIndex++; 
	            } else {
	                break; 
	            }
	        }
	        return hIndex;
	        }
	    public String getName() {
	        return super.getName();
	    }
	    public String getId() {
	        return super.getId();
	    }
	    public void performDuties() {
	        System.out.println("Teaching and conducting research.");
	    }
	    public void displayRole() {
	        System.out.println("Role: Teacher");
	    }
	}



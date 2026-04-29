package oop_project;
import java.util.HashMap;
import java.util.Map;
public class EnglishLanguageStrategy implements LanguageStrategy {

	private final Map<String, String> translations = new HashMap<>();

    public EnglishLanguageStrategy() {
    	
        translations.put("choose_language", "Choose your language: 1) EN  2) RU  3) KZ");
        translations.put("login_prompt", "Please enter your email and password.");
        translations.put("email_prompt", "Email:");
        translations.put("password_prompt", "Password:");
        translations.put("invalid_credentials", "Invalid email or password.");
        translations.put("welcome", "Welcome, ");
        translations.put("logoutORexit", "Type 'logout' to log out or 'exit' to quit the program:");
        translations.put("exit_message", "Exiting the program. Goodbye!");
        translations.put("student_menu", "Student menu: ");
        translations.put("student_menu2", "1. View Transcript\n2. View Marks\n3. Register for Course\n4. Rate Teacher\n5. Send Message\n6. View GPA\n7. View enrolled cources\n8. View news");
        translations.put("course_code", "Enter course credits");
        translations.put("course_name", "Enter course name");
        translations.put("course_credits", "Enter course credits");
        translations.put("course_registr_true", "You register for course. ");
        translations.put("teacher_name", "Enter teacher name: ");
        translations.put("Enter_rating", "Enter rating(1-10): ");
        translations.put("Teacher_notFound", "Teacher not found");
        translations.put("your_gpa", "Your GPA: ");
        translations.put("your_enrolled_courses", "Your enrollend courses:  ");
        translations.put("News_update1", "Important update!");
        translations.put("News_update2", "Details about news");
        translations.put("Teacher_Menu1", "Teacher Menu: ");
        translations.put("Teacher_Menu2", "1. View Courses\n2. Manage Course\n3. Put Marks\n4. Send Complaint\n5. Send Message\n6. View rating\n7. View news\n8. Add research paper\n9. View research paper\n10. Manage research project");
        translations.put("Course_teacher", "Courses: ");
        translations.put("lesson_topic", "Enter lesson topic: ");
        translations.put("lesson_type", "Enter lesson type (PRACTICE/LECTURE): ");
        translations.put("lesson_type_invalid", "Invalid lesson type. Must be PRACTICE or LECTURE.");
        translations.put("Enter_studentName", "Enter student name: ");
        translations.put("Student_notFound", "Student not found.");
        translations.put("Enter_complaint", "Enter complaint: ");
        translations.put("urgency_level", "Enter urgency level(LOW/MEDIUM/HIGH): ");
        translations.put("urgency_level_invalid", "Invalid urgency level. ");
        translations.put("average_rating", "Your average rating: ");
        translations.put("Enter_ResearchPaperTitle", "Enter Research Paper Title: ");
        translations.put("Enter_Author", "Enter Author: ");
        translations.put("Enter_Journal", "Enter Journal: ");
        translations.put("add_RP_true", "You add research paper.");
        translations.put("Sort", "1. Sort by Date\n2. Sort by Citations");
        translations.put("manage_RPr", "Manage Research Projects:");
        translations.put("create_RPr", "1. Create New Project ");
        translations.put("add_RP_RPr", "2. Add Research Paper to Project ");
        translations.put("add_participant", "3. Add Participant to Project ");
        translations.put("view_details", "4. View Project Details ");
        translations.put("go_back", "5. Go back ");
        
        translations.put("your_choice", "Enter your choice:");
        translations.put("enter_project_topic", "Enter Project Topic: ");
        translations.put("create_Rpr_true", "Research project created successfully. ");
        translations.put("project_fall", "No projects available. Create a project first. ");
        translations.put("select_project", "Select a project: ");
        translations.put("add_RP_RPr_true", "Research paper added to the project. ");
        translations.put("select_project_invalid", "Invalid project selection. ");
        translations.put("add_par_type", "Add participant type: 1. Student, 2. Teacher");
        translations.put("student_added", "Student added to the project. ");
        translations.put("teacher_added", "Teacher added to the project. ");
        translations.put("no_aviable", "No projects available.");
        translations.put("Invalid_choice", "Invalid choice.");
        translations.put("project_topic", "Project Topic: ");
        translations.put("r_p", "Research Papers: ");
        translations.put("participants", "Participants: ");
        translations.put("Manager_Menu1", "Manager Menu: ");
        translations.put("Manager_Menu2", "1. Generate Reports\n2. Manage News\n3. Assign Course to Teacher\n4. Approve Student Registration\n5. Add courses for registration\n6. View info\n7. Send message");
        translations.put("Enter_newsTopic", "Enter news topic: ");
        translations.put("Enter_newsContent", "Enter news content: ");
        translations.put("view_all_news", "Viewing all news:");
        translations.put("no_news_aviab","No news available.");
        translations.put("published_news", " You published news.");
        translations.put("Enter_Year", "Enter Year: ");
        translations.put("Enter_major", "Enter major: ");
        translations.put("you_add_course", "You add course.");
        translations.put("Admin_Menu1","Admin Menu: ");
        translations.put("Admin_Menu2", "1. Add User\n2. Update User\n3. Remove User\n4. View Log");
        translations.put("Enter_UserID", "Enter User ID: ");
        translations.put("Enter_Name", "Enter Name: ");
        translations.put("Enter_Email", "Enter Email: ");
        translations.put("Enter_Password", "Enter Password: ");
        translations.put("Enter_Role", "Enter Role (student/teacher/admin/manager): ");
        translations.put("Enter_NewName", "Enter New Name: ");
        translations.put("Enter_NewEmail", "Enter New Email: ");
        translations.put("Enter_UserIDlogs", "Enter User ID to view logs: ");
        translations.put("TechSupport_Menu1","Tech Suppor Menu: ");
        translations.put("TechSupport_Menu2", "1. Create and Add Order\n2. Resolve Order\n3. View all orders ");
        translations.put("Enter_OrderDescription", "Enter order description: ");
        translations.put("Choose_anOrderToResolve", "Choose an order to resolve: ");
        translations.put("Enter_OrderNumber", "Enter order number: ");
        translations.put("Invalid_OrderNumber", "Invalid order number.");
        translations.put("All_Orders", "All Orders: ");
        translations.put("Enter_RecipientEmail", "Enter recipient email: ");
        translations.put("Enter_MessageContent: ", "Enter message content: ");
        translations.put("Message_Sent", "Message sent: ");
        
    }

    public String getTranslation(String key) {
        return translations.getOrDefault(key, key);
    }
}

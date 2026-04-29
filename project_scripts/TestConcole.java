package oop_project;
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class TestConcole {
	
	private static LanguageContext context;
    private static Map<String, User> usersDB = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        NewsPublisher publisher = new NewsPublisher();
        loadDatabase(); // Загрузка данных из файла
        usersDB.values().forEach(user -> {
            if (user instanceof Observer) {
                publisher.addObserver((Observer) user);
            }
        });
        while (true) {
            selectLanguage(); // Выбор языка программы

            User user = login(); // Аутентификация
            if (user == null) {
                System.out.println(context.getTranslation("exit_message"));
                break;
            }

            while (true) {
                // Меню в зависимости от роли пользователя
                if (user instanceof Student) studentMenu((Student) user,publisher);
                else if (user instanceof Teacher) teacherMenu((Teacher) user,publisher);
                else if (user instanceof Manager) managerMenu((Manager) user,publisher);
                else if (user instanceof Admin) adminMenu((Admin) user);
                else if (user instanceof TechSupporter) techSupportMenu((TechSupporter) user);
                else System.out.println("unknown_role");

                System.out.println(context.getTranslation("logoutORexit"));
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("logout")) break;
                if (choice.equalsIgnoreCase("exit")) {
                    System.out.println(context.getTranslation("exit_message"));
                    return;
            }
                }
        }
    }

    // Загрузка базы данных пользователей из файла
    private static void loadDatabase() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Admin\\eclipse-workspace\\oop_project\\src\\oop_project\\users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                String email = parts[2];
                String password = parts[3];
                String role = parts[4];

                User user = switch (role.toLowerCase()) {
                    case "student" -> new Student(id, name, email, Integer.parseInt(parts[5]), password);
                    case "teacher" -> new Teacher(id, name, email, password);
                    case "manager" -> new Manager(id, name, email, password);
                    case "admin" -> new Admin(id, name, email, password);
                    case "techsupporter" -> new TechSupporter(id, name, email, password);
                    default -> null;
                };

                if (user != null) usersDB.put(email, user);
            }
        }
    }

    // Выбор языка программы
    private static void selectLanguage() {
        System.out.println("Choose your language: 1 - English, 2 - Russian, 3 - Kazakh:");
        int choice = Integer.parseInt(scanner.nextLine());
        String language = switch (choice) {
            case 1 -> "EN";
            case 2 -> "RU";
            case 3 -> "KZ";
            default -> "EN";
        };
        context = new LanguageContext(language);
    }

    // Аутентификация пользователя
    private static User login() {
        System.out.println(context.getTranslation("login_prompt"));
        System.out.print(context.getTranslation("email_prompt"));
        String email = scanner.nextLine();
        System.out.print(context.getTranslation("password_prompt"));
        String password = scanner.nextLine();

        User user = usersDB.get(email);
        if (user != null && user.checkPassword(password)) {
            System.out.println(context.getTranslation("welcome") + user.getName());
            return user;
        } else {
            System.out.println(context.getTranslation("invalid_credentials"));
            return null;
        }
    }

    // Меню для студента
    private static void studentMenu(Student student,NewsPublisher publisher) {
        System.out.println(context.getTranslation("student_menu"));
        System.out.println(context.getTranslation("student_menu2"));
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> student.viewTranscript();
            case 2 -> student.viewMarks();
            case 3 -> {
                System.out.print(context.getTranslation("course_code"));
                String code = scanner.nextLine();
                System.out.print(context.getTranslation("course_name"));
                String name = scanner.nextLine();
                System.out.print(context.getTranslation("course_credits"));
                int credits = scanner.nextInt();
                scanner.nextLine();
                Course course = new Course(code, name,credits); 
                student.registerForCourse(course);
                System.out.print(context.getTranslation("course_registr_true"));
            }
            case 4 -> {
                System.out.print(context.getTranslation("teacher_name"));
                String teacherName = scanner.nextLine();
                Teacher teacher = (Teacher) usersDB.values().stream()
                        .filter(u -> u instanceof Teacher && u.getName().equals(teacherName))
                        .findFirst()
                        .orElse(null);
                if (teacher != null) {
                    System.out.print(context.getTranslation("Enter_rating"));
                    int rating = Integer.parseInt(scanner.nextLine());
                    student.rateTeacher(teacher, rating);
                } else {
                    System.out.println(context.getTranslation("Teacher_notFound"));
                }
            }
            case 5 -> sendMessage(student);
            case 6 -> System.out.print(context.getTranslation("your_gpa")+ student.getGPA());
            case 7 -> System.out.print(context.getTranslation("your_enrolled_courses") + student.getEnrolledCourses());
            case 8 -> {
                System.out.println(context.getTranslation("view_all_news"));
                List<News> newsList = publisher.getPublishedNews();
                if (newsList.isEmpty()) {
                    System.out.println(context.getTranslation("no_news_aviab"));
                } else {
                    for (News news : newsList) {
                        System.out.println(news.getTopic() + ": " + news.getContent());
                    }
                }
                }
            
            default -> System.out.println(context.getTranslation("Invalid_choice"));
        }
        }
    
    // Меню для учителя
    private static void teacherMenu(Teacher teacher,NewsPublisher publisher) {
        System.out.println(context.getTranslation("Teacher_Menu1"));
        System.out.println(context.getTranslation("Teacher_Menu2"));
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> System.out.println(context.getTranslation("Course_teacher") + teacher.viewCourses());
            case 2 -> {
                System.out.print(context.getTranslation("course_code"));
                String code = scanner.nextLine();
                System.out.print(context.getTranslation("course_name"));
                String name = scanner.nextLine();
                System.out.print(context.getTranslation("course_credits"));
                int credits = scanner.nextInt();
                scanner.nextLine();
                Course course = new Course(code, name, credits); 
                System.out.print(context.getTranslation("lesson_topic"));
                String topic = scanner.nextLine();
                System.out.print(context.getTranslation("lesson_type"));
                String typeInput = scanner.nextLine().toUpperCase(); 

                try {
                    LessonType type = LessonType.valueOf(typeInput); 
                    Lesson lesson = new Lesson(topic, type);
                    teacher.manageCourse(course, lesson);
                } catch (IllegalArgumentException e) {
                    System.out.println(context.getTranslation("lesson_type_invalid"));
                }
            }
            
               
            case 3 -> {
                System.out.print(context.getTranslation("Enter_studentName"));
                String studentName = scanner.nextLine();
                Student student = (Student) usersDB.values().stream()
                        .filter(u -> u instanceof Student && u.getName().equals(studentName))
                        .findFirst()
                        .orElse(null);
                if (student != null) {
                    System.out.print(context.getTranslation("course_code"));
                    String code = scanner.nextLine();
                    System.out.print(context.getTranslation("course_name"));
                    String name = scanner.nextLine();
                    System.out.print(context.getTranslation("course_credits"));
                    int credits = scanner.nextInt();
                    scanner.nextLine();
                    Course course = new Course(code, name, credits);
                    teacher.putMarks(student, course, new Mark(80, 85, 90, course));
                } else {
                    System.out.println(context.getTranslation("Student_notFound"));
                }
            }
            case 4 -> {
                System.out.print(context.getTranslation("Enter_studentName"));
                String studentName = scanner.nextLine();
                Student student = (Student) usersDB.values().stream()
                        .filter(u -> u instanceof Student && u.getName().equals(studentName))
                        .findFirst()
                        .orElse(null);
                if (student != null) {
                    System.out.print(context.getTranslation("Enter_complaint"));
                    String complaint = scanner.nextLine();
                   
                    System.out.print(context.getTranslation("urgency_level"));
                    String typeInput = scanner.nextLine().toUpperCase();
                    try {
                        UrgencyLevel type = UrgencyLevel.valueOf(typeInput); 
                        teacher.sendComplaint(student, complaint, type);
                    } catch (IllegalArgumentException e) {
                        System.out.println(context.getTranslation("urgency_level_invalid"));
                    }
                } else {
                    System.out.println(context.getTranslation("Student_notFound"));
                }
            }
            case 5 -> sendMessage(teacher);
            case 6->  System.out.print(context.getTranslation("average_rating")+ teacher.getAverageRating());
            case 7 -> {
                System.out.println(context.getTranslation("view_all_news"));
                List<News> newsList = publisher.getPublishedNews();
                if (newsList.isEmpty()) {
                    System.out.println(context.getTranslation("no_news_aviab"));
                } else {
                    for (News news : newsList) {
                        System.out.println(news.getTopic() + ": " + news.getContent());
                    }
                }
            }
            case 8-> {  
            	System.out.print(context.getTranslation("Enter_ResearchPaperTitle"));
                String title = scanner.nextLine();
                System.out.print(context.getTranslation("Enter_Author:"));
                String author = scanner.nextLine();
                System.out.print(context.getTranslation("Enter_Journal"));
                String journal = scanner.nextLine();
                ResearchPaper paper = new ResearchPaper(title, author,journal, LocalDate.now(), new Random().nextInt(100));
                teacher.addResearchPaper(paper);
                teacher.calculateHIndex();
                System.out.print(context.getTranslation("add_RP_true"));
            }
            case 9 ->{
            	System.out.println(context.getTranslation("Sort"));
                int sortChoice = scanner.nextInt();
                scanner.nextLine();
                SortStrategy strategy = sortChoice == 1 ? new SortByDate() : new SortByCitations();
                ResearcherWithSorting researcher = new ResearcherWithSorting(strategy);
                for (ResearchPaper paper : teacher.getResearchPapers()) {
                    researcher.addResearchPaper(paper);
                }
                researcher.printSortedPapers();
            }
            case 10->{List<ResearchProject> projects = new ArrayList<>();

            while (true) {
                System.out.println(context.getTranslation("manage_RPr"));
                System.out.println(context.getTranslation("create_RPr"));
                System.out.println(context.getTranslation("add_RP_RPr"));
                System.out.println(context.getTranslation("add_participant"));
                System.out.println(context.getTranslation("view_details"));
                System.out.println(context.getTranslation("go_back"));

                System.out.print(context.getTranslation("your_choice"));
                int choicePROJ = Integer.parseInt(scanner.nextLine());

                switch (choicePROJ) {
                    case 1 -> {
                        System.out.print(context.getTranslation("enter_project_topic"));
                        String topic = scanner.nextLine();
                        ResearchProject project = new ResearchProject(topic);
                        projects.add(project);
                        System.out.println(context.getTranslation("create_Rpr_true"));
                    }
                    case 2 -> {
                        if (projects.isEmpty()) {
                            System.out.println(context.getTranslation("project_fall"));
                            break;
                        }
                        System.out.println(context.getTranslation("select_project"));
                        for (int i = 0; i < projects.size(); i++) {
                            System.out.println((i + 1) + ". " + projects.get(i).getTopic());
                        }
                        int projectIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (projectIndex >= 0 && projectIndex < projects.size()) {
                            System.out.print(context.getTranslation("Enter_ResearchPaperTitle"));
                            String title = scanner.nextLine();
                            System.out.print(context.getTranslation("Enter_Author"));
                            String author = scanner.nextLine();
                            System.out.print(context.getTranslation("Enter_Journal"));
                            String journal = scanner.nextLine();
                            ResearchPaper paper = new ResearchPaper(title, author, journal, LocalDate.now(), new Random().nextInt(100));
                            projects.get(projectIndex).addPaper(paper);
                            System.out.println(context.getTranslation("add_RP_RPr_true"));
                        } else {
                            System.out.println(context.getTranslation("select_project_invalid"));
                        }
                    }
                    case 3 -> {
                        if (projects.isEmpty()) {
                            System.out.println(context.getTranslation("project_fall"));
                            break;
                        }
                        System.out.println(context.getTranslation("select_project"));
                        for (int i = 0; i < projects.size(); i++) {
                            System.out.println((i + 1) + ". " + projects.get(i).getTopic());
                        }
                        int projectIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (projectIndex >= 0 && projectIndex < projects.size()) {
                            System.out.println(context.getTranslation("add_par_type"));
                            int participantType = Integer.parseInt(scanner.nextLine());
                            switch (participantType) {
                                case 1 -> { // Добавление студента
                                    System.out.print(context.getTranslation("Enter_studentName"));
                                    String studentName = scanner.nextLine();
                                    Student student = (Student) usersDB.values().stream()
                                            .filter(u -> u instanceof Student && u.getName().equals(studentName))
                                            .findFirst()
                                            .orElse(null);
                                    if (student != null) {
                                        projects.get(projectIndex).addParticipant(student);
                                        System.out.println(context.getTranslation("student_added"));
                                    } else {
                                        System.out.println(context.getTranslation("Student_notFound"));
                                    }
                                }
                                case 2 -> { // Добавление учителя
                                    System.out.print(context.getTranslation("teacher_name"));
                                    String teacherName = scanner.nextLine();
                                    Teacher teacherPROJ = (Teacher) usersDB.values().stream()
                                            .filter(u -> u instanceof Teacher && u.getName().equals(teacherName))
                                            .findFirst()
                                            .orElse(null);
                                    if (teacher != null) {
                                        projects.get(projectIndex).addParticipant(teacherPROJ);
                                        System.out.println(context.getTranslation("teacher_added"));
                                    } else {
                                        System.out.println(context.getTranslation("Teacher_notFound"));
                                    }
                                }
                                default -> System.out.println(context.getTranslation("Invalid_choice"));
                            }
                        } else {
                            System.out.println(context.getTranslation("select_project_invalid"));
                        }
                    }
                    case 4 -> {
                        if (projects.isEmpty()) {
                            System.out.println(context.getTranslation("no_aviable"));
                            break;
                        }
                        System.out.println(context.getTranslation("select_project"));
                        for (int i = 0; i < projects.size(); i++) {
                            System.out.println((i + 1) + ". " + projects.get(i).getTopic());
                        }
                        int projectIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (projectIndex >= 0 && projectIndex < projects.size()) {
                            ResearchProject project = projects.get(projectIndex);
                            System.out.println(context.getTranslation("project_topic") + project.getTopic());
                            System.out.println(context.getTranslation("r_p"));
                            project.getPapers().forEach(paper -> System.out.println("- " + paper));
                            System.out.println(context.getTranslation("participants"));
                            project.getParticipants().forEach(participant -> System.out.println("- " + participant.getName()));
                        } else {
                            System.out.println(context.getTranslation("select_project_invalid"));
                        }
                    }
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println(context.getTranslation("Invalid_choice"));
                }
            }
        }
            
            default -> System.out.println(context.getTranslation("Invalid_choice"));
        }
    }

    // Меню для менеджера
    private static void managerMenu(Manager manager,NewsPublisher publisher) {
        System.out.println(context.getTranslation("Manager_Menu1"));
        System.out.println(context.getTranslation("Manager_Menu2"));
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> manager.generatePerformanceReport(usersDB.values().stream()
                    .filter(u -> u instanceof Student)
                    .map(u -> (Student) u)
                    .toList());
            case 2 ->  {System.out.print(context.getTranslation("Enter_newsTopic"));
            String topic = scanner.nextLine();
            System.out.print(context.getTranslation("Enter_newsContent"));
            String content = scanner.nextLine();
            manager.publishNews(topic, content, publisher);
            System.out.print(context.getTranslation("published_news"));
            }
            case 3 -> {
                System.out.print(context.getTranslation("course_code"));
                String code = scanner.nextLine();
                System.out.print(context.getTranslation("course_name"));
                String name = scanner.nextLine();
                System.out.print(context.getTranslation("course_credits"));
                int credits = scanner.nextInt();
                scanner.nextLine();
                Course course = new Course(code,name,credits);
                System.out.print(context.getTranslation("teacher_name"));
                String teacherName = scanner.nextLine();
                Teacher teacher = (Teacher) usersDB.values().stream()
                        .filter(u -> u instanceof Teacher && u.getName().equals(teacherName))
                        .findFirst()
                        .orElse(null);
                if (teacher != null) manager.assignCourseToTeacher(course, teacher);
                else System.out.println(context.getTranslation("Teacher_notFound"));
            }
            case 4 -> {
                System.out.print(context.getTranslation("Enter_studentName"));
                String studentName = scanner.nextLine();
                Student student = (Student) usersDB.values().stream()
                        .filter(u -> u instanceof Student && u.getName().equals(studentName))
                        .findFirst()
                        .orElse(null);
                System.out.print(context.getTranslation("course_code"));
                String code = scanner.nextLine();
                System.out.print(context.getTranslation("course_name"));
                String name = scanner.nextLine();
                System.out.print(context.getTranslation("course_credits"));
                int credits = scanner.nextInt();
                scanner.nextLine();
                Course course = new Course(code, name,credits );
                if (student != null) manager.approveStudentRegistration(student, course);
                else System.out.println(context.getTranslation("Student_notFound"));
            }
            case 5 ->{
            	System.out.print(context.getTranslation("course_code"));
                String code = scanner.nextLine();
            	System.out.print(context.getTranslation("course_name"));
                String name = scanner.nextLine();
                System.out.print(context.getTranslation("Enter_Year"));
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.print(context.getTranslation("course_credits"));
                int credits = scanner.nextInt();
                scanner.nextLine();
                System.out.print(context.getTranslation("Enter_major"));
                String major = scanner.nextLine();
                Course course = new Course(code, name, credits);
                manager.addCourseForRegistration(course,year,major);
                System.out.print(context.getTranslation("you_add_course"));
            }
            case 6 ->manager.viewInfo(new ArrayList<>(), new ArrayList<>(), Comparator.comparing(User::getName));
            case 7 ->sendMessage(manager);
            default -> System.out.println(context.getTranslation("Invalid_choice"));
        }
    }

    // Меню для администратора
    private static void adminMenu(Admin admin) {
        System.out.println(context.getTranslation("Admin_Menu1"));
        System.out.println(context.getTranslation("Admin_Menu2"));
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> {
            	 System.out.print(context.getTranslation("Enter_UserID"));
                 String id = scanner.nextLine();
                 System.out.print(context.getTranslation("Enter_Name"));
                 String name = scanner.nextLine();
                 System.out.print(context.getTranslation("Enter_Email"));
                 String email = scanner.nextLine();
                 System.out.print(context.getTranslation("Enter_Password"));
                 String password = scanner.nextLine();
                 System.out.print(context.getTranslation("Enter_Role"));
                 String role = scanner.nextLine();
                 User user = UserFactory.createUser(role, id, name, email,password, 0);
                 admin.addUser(user);
                }
                
            case 2 ->  {System.out.print(context.getTranslation("Enter_UserID"));
            String id = scanner.nextLine();
            System.out.print(context.getTranslation("Enter_NewName"));
            String name = scanner.nextLine();
            System.out.print(context.getTranslation("Enter_NewEmail"));
            String email = scanner.nextLine();
            admin.updateUser(id, name, email);
            }
            case 3 -> {
            System.out.print(context.getTranslation("Enter_UserID"));
            String id = scanner.nextLine();
            admin.removeUser(id);
            }
            case 4 -> {
            	System.out.print(context.getTranslation("Enter_UserIDlogs"));
                String id = scanner.nextLine();
                admin.viewLogs(id);
            }
            default -> System.out.println(context.getTranslation("Invalid_choice"));
        }
    }

    // Меню для техподдержки
    private static void techSupportMenu(TechSupporter techSupporter) {
        System.out.println(context.getTranslation("TechSupport_Menu1"));
        System.out.println(context.getTranslation("TechSupport_Menu2"));
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> {
            	System.out.print(context.getTranslation("Enter_OrderDescription"));
                String description = scanner.nextLine();
                Order order = new Order(description);
                techSupporter.addOrder(order);
            }
            case 2 -> {
            	 System.out.println(context.getTranslation("Choose_anOrderToResolve"));
                 List<Order> orders = techSupporter.getOrders(); 
                 for (int i = 0; i < orders.size(); i++) {
                     System.out.println((i + 1) + ". " + orders.get(i));
                 }
                 System.out.print(context.getTranslation("Enter_OrderNumber"));
                 int orderIndex = Integer.parseInt(scanner.nextLine()) - 1;
                 if (orderIndex >= 0 && orderIndex < orders.size()) {
                     techSupporter.resolveOrder(orders.get(orderIndex));
                 } else {
                     System.out.println(context.getTranslation("Invalid_OrderNumber"));
                 }
            }
            case 3 ->{
            	 List<Order> orders = techSupporter.getOrders();
                 System.out.println(context.getTranslation("All_Orders"));
                 for (Order order : orders) {
                     System.out.println(order);
            }
                 }
            default -> System.out.println(context.getTranslation("Inavalid_choice"));
        }
    }

    // Метод отправки сообщения
    private static void sendMessage(User sender) {
        System.out.print(context.getTranslation("Enter_RecipientEmail"));
        String recipientEmail = scanner.nextLine();
        System.out.print(context.getTranslation("Enter_MessageContent:"));
        String content = scanner.nextLine();
        Message message = new Message(sender.getEmail(), recipientEmail, content);
        System.out.println(context.getTranslation("Message_Sent") + message.getContent());
    }
}
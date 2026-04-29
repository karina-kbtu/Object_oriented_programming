package oop_project;
import java.util.Map;
import java.util.HashMap;
public class RussianLanguageStrategy implements LanguageStrategy {

	 private final Map<String, String> translations = new HashMap<>();

	    public RussianLanguageStrategy() {
	       
	    	translations.put("choose_language", "Выберите язык: 1) EN  2) RU  3) KZ");
	    	translations.put("login_prompt", "Введите ваш email и пароль.");
	    	translations.put("email_prompt", "Электронная почта:");
	    	translations.put("password_prompt", "Пароль:");
	    	translations.put("invalid_credentials", "Неверный email или пароль.");
	    	translations.put("welcome", "Добро пожаловать, ");
	    	translations.put("logoutORexit", "Введите 'logout', чтобы выйти из системы, или 'exit', чтобы выйти из программы");
	        translations.put("exit_message", "Выход из программы. До свидания!");
	        translations.put("student_menu", "Меню студента: ");
	        translations.put("student_menu2", "1. Посмотреть транскрипт\n2. Посмотреть оценки\n3. Зарегистрироваться на предмет\n4. Оценить учителя\n5. Отправить сообщение\n6. Посмотреть ГПА\n7. Посмотреть зарегистрированные курсы\n8. Посмотреть новости");
	        translations.put("course_code", "Введите кол-во код курса");
	        translations.put("course_name", "Введите кол-во имя курса");
	        translations.put("course_credits", "Введите кол-во кредитов курса");
	        translations.put("course_registr_true", "Вы зарегистрировались на курс. ");
	        translations.put("teacher_name", "Введите имя преподавателя: ");
	        translations.put("Enter_rating", "Поставьте оценку(1-10): ");
	        translations.put("Teacher_notFound", "Учитель не найден");
	        translations.put("your_gpa", "Ваш GPA: ");
	        translations.put("your_enrolled_courses", "Курсы,на котороые вы зарегестрированны: ");
	        translations.put("News_update1", "Важное обновление!");
	        translations.put("News_update2", "Детали о новостях.");
	        translations.put("Teacher_Menu1", "Меню преподователя:");
	        translations.put("Teacher_Menu2", "1. Просмотр курсов\n2. Управление курсом\n3. Ставьте отметки\n4. Отправить жалобу\n5. Отправить сообщение\n6. Посмотреть рейтинг\n7. Просмотр новостей\n8. Добавьте исследовательскую работу\n9. Посмотреть исследовательскую работу\n10. Управление исследовательскими проектами");
	        translations.put("Course_teacher", "Курсы: ");
	        translations.put("lesson_topic", "Введите тему урока: ");
	        translations.put("lesson_type", "Введите тип урока (PRACTICE/LECTURE): ");
	        translations.put("lesson_type_invalid", "Неправильный тип урока. Урок может быть PRACTICE или LECTURE.");
	        translations.put("Enter_studentName", "Введите имя студента: ");
	        translations.put("Student not found", "Студент не нашелся.");
	        translations.put("Enter complaint", "Введите жалобу:");
	        translations.put("urgency_level", "Введите уровень жалобы(LOW/MEDIUM/HIGH): ");
	        translations.put("urgency_level_invalid", "Неправильный тип уровня жалобы. ");
	        translations.put("average_rating", "Средний показатель вашего рейтинга: ");
	        translations.put("Enter_ResearchPaperTitle: ", "Введите название научной статьи:");
	        translations.put("Enter_Author", "Введите автора:");
	        translations.put("Enter_Journal", "Войти в журнал: ");
	        translations.put("add_RP_true", "Вы добавили научную статью.");
	        translations.put("Sort", "1. Сортировка по дате\n2. Сортировка по цитированию");
	        translations.put("manage_RPr", "Управление научными проектами:");
	        translations.put("create_RPr", "1. Создать новый проект ");
	        translations.put("add_RP_RPr", "2. Добавить научную статью в проектю");
	        translations.put("add_participant", "3. Добавить участника ");
	        translations.put("view_details", "4. Посмотреть детали научного проекта ");
	        translations.put("go_back", "5. Вернуться ");
	        
	        translations.put("your_choice", "Введите ваш выбор:");
	        translations.put("enter_project_topic", "Введите тему проекта: ");
	        translations.put("create_Rpr_true", "Научный проект создан успешно ");
	        translations.put("project_fall", "Проекта не доступен. Сначала создайте проект. ");
	        translations.put("select_project", "Выберите проект: ");
	        translations.put("add_RP_RPr_true", "Научная ставтья добавлена в проект. ");
	        translations.put("select_project_invalid", "Неправльный выбор проекта. ");
	        translations.put("add_par_type", "Добавление участников: 1. Студент 2. Преподаватель");
	        translations.put("student_added", "Студент добавлен в проект. ");
	        translations.put("teacher_added", "Преподаватель добавлен в проект. ");
	        translations.put("no_aviable", "Проект не доступен.");
	        
	        translations.put("view_all_news", "Просмотр всех новостей:");
	        translations.put("no_news_aviab","Новости не доступны.");
	        translations.put("project_topic", "Тема проекта: ");
	        translations.put("r_p", "Научная статья: ");
	        translations.put("participants", "Участники: ");
	       
	        translations.put("Invalid_choice.", "Неправильный выбор");
	        translations.put("Manager_Menu1", "Меню менеджера:");
	        translations.put("Manager_Menu2", "1. Создание отчетов\n2. Управление новостями\n3. Назначить курс преподавателю\n4. Одобрить регистрацию студента\n5. Добавьте курсы для регистрации\n6. Посмотреть информацию\n7. Отправить сообщение");
	        translations.put("Enter_newsTopic", "Введите тему новости: ");
	        translations.put("Enter_newsContent", "Введите содержание новости:");
	        translations.put("Enter_Year", "Введите год: ");
	        translations.put("Enter_major", "Введите специальность: "); 
	        translations.put("published_news", " Вы опубликовали новости.");
	        translations.put("you_add_course", "Вы добавили курс.");
	        translations.put("Admin_Menu1", "Меню админа: ");
	        translations.put("Admin_Menu2", "1. Добавить пользователя\n2. Обновить пользователя\n3. Удалить пользователя\n4. Просмотр журнала");
	        translations.put("Enter_UserID: ", "Введите идентификатор пользователя:");
	        translations.put("Enter_Name", "Введите имя: ");
	        translations.put("Enter_Email", "Введите эл.почту: ");
	        translations.put("Enter_Password", "Введите пароль: ");
	        translations.put("EnterRole", "Введите роль (ученик/преподаватель/администратор/менеджер):");
	        translations.put("Enter_NewName: ", "Введите новое имя: ");
	        translations.put("Enter_NewEmail", "Введите новый адрес электронной почты:");
	        translations.put("Enter_UserIDlogs", "Введите идентификатор пользователя для просмотра журналов: ");
	        translations.put("TechSupport_Menu1", "Меню технической поддержки:");
	        translations.put("TechSupport_Menu2", "1. Создайте и добавьте заказ\n2. Выполните заказ\n3. Просмотреть все заказы");
	        translations.put("Enter_OrderDescription", "Введите описание заказа: ");
	        translations.put("Choose_anOrderToResolve", "Выберите порядок решения: ");
	        translations.put("Enter_OrderNumber", "Введите номер заказа: ");
	        translations.put("Invalid_OrderNumber", "Неверный номер заказа");
	        translations.put("All_Orders", "Все заказы: ");
	        translations.put("Enter_RecipientEmail", "Введите адрес электронной почты получателя: ");
	        translations.put("Enter_MessageContent", "Введите содержание сообщения: ");
	        translations.put("Message_Sent", "Сообщение отправлено: ");
	        }
	    public String getTranslation(String key) {
	        return translations.getOrDefault(key, key);
	    }

}

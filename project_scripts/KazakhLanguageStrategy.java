package oop_project;
import java.util.Map;
import java.util.HashMap;
public class KazakhLanguageStrategy implements LanguageStrategy {

	private final Map<String, String> translations = new HashMap<>();

    public KazakhLanguageStrategy() {
    	translations.put("choose_language", "Тілді таңдаңыз: 1) EN  2) RU  3) KZ");
    	translations.put("login_prompt", "Электрондық пошта мен құпиясөзді енгізіңіз.");
    	translations.put("email_prompt", "Электрондық пошта:");
    	translations.put("password_prompt", "Құпиясөз:");
    	translations.put("invalid_credentials", "Электрондық пошта немесе құпиясөз дұрыс емес.");
    	translations.put("welcome", "Қош келдіңіз, ");
    	translations.put("logoutORexit", "Жүйеден шығу үшін 'logout' немесе бағдарламадан шығу үшін 'exit' деп теріңіз");
        translations.put("exit_message", "Бағдарламадан шығу. Сау болыңыз!");
        translations.put("student_menu", "Студент мәзірі");
        translations.put("student_menu2", "1. Транскриптін қараңыз\n2. Бағаларын қараңы\n3. Пәніне тіркелу\n4. Мұғалімді бағалау\n5. Хабарлама жіберу\n6. GPA қараңыз\n7. Тіркелген курстарды қараңыз\n8. Жаңалықтарды қараңыз");
        translations.put("course_code", "Курстан несие кодын енгізіңіз");
        translations.put("course_name", "Курстан несие атын енгізіңіз");
        translations.put("course_credits", "Курстан несие санын енгізіңіз");
        translations.put("course_registr_true", "Сіз курсқа тіркелдіңіз");
        translations.put("teacher_name", "Мұғалімнің атын енгізіңіз: ");
        translations.put("Enter_rating", "Баға қойыңыз(1-10): ");
        translations.put("Teacher_notFound", "Мұғалім табылмады");
        translations.put("your_gpa", "Сіздің GPA: ");
        translations.put("your_enrolled_courses", "Cіздің тіркелген курстарыңыз: ");
        translations.put("News_update1", "Маңызды жаңарту!");
        translations.put("News_update2", "Жаңалықтар туралы мәліметтер.");
        translations.put("Teacher_Menu1", "Мұғалімнің мәзірі:");
        translations.put("Teacher_Menu2", "1. Курстарды қарау\n2. Курсты басқару\n3. Белгілерді қойыңыз\n4. Шағым беріңіз\n5. Хабарлама жіберіңіз\n6. Рейтингті қарау\n7. Жаңалықтарды көру\n8. Зерттеу жұмысын қосыңыз\n9. Зерттеу жұмысын қараңыз\n10. Зерттеу жобаларын басқару");
        translations.put("Course_teacher", "Курстар: ");
        translations.put("lesson_topic", "Сабақ тақырыбын енгізіңіз: ");
        translations.put("lesson_type","Cабақ түрін енгізіңіз(PRACTICE/LECTURE): ");
        translations.put("lesson_type_invalid", "Сабақтың дұрыс емес түрі. Сабақ PRACTICE немесе LECTURE болуы мүмкін.");
        translations.put("urgency_level", "Шағым деңгейін енгізіңіз(LOW/MEDIUM/HIGH): ");
        translations.put("urgency_level_invalid", "Шағым деңгейінің дұрыс емес түрі. ");
        translations.put("average_rating", "Сіздің рейтингіңіздің орташа көрсеткіші: ");
        translations.put("Enter_studentName", "Студенттің атын енгізіңіз:");
        translations.put("Student_notFound.", "Студент табылмады.");
        translations.put("Enter_complaint", "Шағым жазыңыз:");
        translations.put("Enter_ResearchPaperTitle", "Ғылыми мақаланың тақырыбын енгізіңіз:");
        translations.put("Enter_Author", "Авторды енгізіңіз:");
        translations.put("Enter_Journal", "Журналға кіру:");
        translations.put("add_RP_true", "Сіз ғылыми мақала қостыңыз.");
        translations.put("Sort", "1. Күні бойынша сұрыптау\n2. Дәйексөз бойынша сұрыптау");
        translations.put("manage_RPr", "Ғылыми жобаларды басқару:");
        translations.put("create_RPr", "1. Жаңа жоба жасаңыз ");
        translations.put("add_RP_RPr", "2.  Жобаға зерттеу жұмысын қосыңыз ");
        translations.put("add_participant", "3. Жобаға қатысушы қосу ");
        translations.put("view_details", "4. Жоба мәліметтерін қарау ");
        translations.put("go_back", "5. Қайту");
       
        translations.put ("your_choice", "Tаңдауыңызды енгізіңіз: ");
        translations.put ("enter_project_topic", "Жоба тақырыбын енгізіңіз: ");
        translations.put ("create_Rp_true", "Ғылыми жоба сәтті жасалды.");
        translations.put ("project_fall", "Жоба қол жетімді емес жобаны құра бастады. ");
        translations.put ("select_project", "Жобаны таңдаңыз:");
        translations.put ("add_RP_Rp_true", "Жобаға ғылыми мақала қосылды. ");
        translations.put ("select_project_invalid", "Жобаны дұрыс таңдау. ");
        translations.put ("add_par_type", "Бөлімдерді қосу: 1. Студент 2. Аян");
        translations.put ("student_added", "Студент жобаға қосылды.");
        translations.put ("teacher_added", "Оқытушы жобаға қосылды. ");
        translations.put ("no_available", "Жоба қол жетімді емес.");
        translations.put ("project_topic", " Жоба тақырыбы: ");
        translations.put ("r_p", " Ғылыми мақала:");
        translations.put("participants", "Қатысушылар: ");
        translations.put("Invalid_choice.", "Қате таңдау");
        translations.put("Manager_Menu1", "Менеджер мәзірі: ");
        
        translations.put("view_all_news", "Барлық жаңалықтарды көру:");
        translations.put("no_news_aviav","Жаңалықтар қол жетімді емес.");
        
        translations.put("Manager_Menu2", "1. Есептер жасау\n2. Жаңалықтарды басқару\n3. Курсты мұғалімге тағайындау\n4. Студенттердің тіркелуін мақұлдау\n5. Тіркелу үшін курстарды қосу\n6. Ақпаратты көру\n7. Хабарлама жіберу");
        translations.put("Enter_newsTopic", "Жаңалық тақырыбын енгізіңіз:");
        translations.put("Enter_newsContent", "Жаңалық мазмұнын енгізіңіз:");
        translations.put("published_news", " Сіз жаңалықтарды жарияладыңыз.");
        translations.put("Enter_CourseCode", "Курс кодын енгізіңіз:");
        translations.put("Enter_CourseName", "Курс атын енгізіңіз:");
        translations.put("Enter_Year", "Жылды енгізіңіз:");
        translations.put("you_add_course", "Сіз курсты қостыңыз.");
        translations.put("Enter_Major", "Мамандығыңызды енгізіңіз:");
        translations.put("Admin_Menu1", "Әкімші мәзірі: ");
        translations.put("Admin_Menu2", "1. Пайдаланушы қосу\n2. Пайдаланушыны жаңарту\n3. Пайдаланушыны жою\n4. Журналды қарау");
        translations.put("Enter_UserID", "Пайдаланушы идентификаторыңызды енгізіңіз:");
        translations.put("Enter_Name", "Атын енгізіңіз:");
        translations.put("Enter_Email", "Электрондық поштаны енгізіңіз: ");
        translations.put("Enter_Password", "Құпия сөзді енгізіңіз:");
        translations.put("Enter_Role", "Рөлді енгізіңіз (студент/мұғалім/әкімші/менеджер):");
        translations.put("Enter_NewName", "Жаңа атау енгізіңіз:");
        translations.put("Enter_NewEmail", "Жаңа электрондық пошта мекенжайын енгізіңіз:");
        translations.put("Enter_UserIDlogs", "Журналдарды көру үшін пайдаланушы идентификаторыңызды енгізіңіз:");
        translations.put("TechSupport_Menu1", "Техникалық қолдау мәзірі: ");
        translations.put("TechSupport_Menu2", "1. Тапсырыс жасау және қосу\n2. Тапсырысты аяқтау\n3. Барлық тапсырыстарды көру");
        translations.put("Enter_OrderDescription", "Тапсырыс сипаттамасын енгізіңіз:");
        translations.put("Choose_anOrderToResolve", "Шешім ретін таңдаңыз: ");
        translations.put("Enter_OrderNumber", "Тапсырыс нөміріңізді енгізіңіз: ");
        translations.put("Invalid_OrderNumber", "Тапсырыс нөмірі жарамсыз");
        translations.put("All_Orders", "Барлық тапсырыстар: ");
        translations.put("Enter_RecipientEmail", "Алушының электрондық пошта мекенжайын енгізіңіз: ");
        translations.put("Enter_Messagecontent", "Хабарлама мазмұнын енгізіңіз: ");
        translations.put("Message_Sent", "Хабар жіберілді: ");
    }

    public String getTranslation(String key) {
        return translations.getOrDefault(key, key);
    }

}

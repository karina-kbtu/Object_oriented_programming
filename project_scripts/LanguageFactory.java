package oop_project;

public class LanguageFactory {
	public static LanguageStrategy createLanguage(String language) {
        switch (language.toUpperCase()) {
            case "EN":
                return new EnglishLanguageStrategy();
            case "RU":
                return new RussianLanguageStrategy();
            case "KZ":
                return new KazakhLanguageStrategy();
            default:
                return new EnglishLanguageStrategy(); // Default to English if language is not supported
        }
    }
}

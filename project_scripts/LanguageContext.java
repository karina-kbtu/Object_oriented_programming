package oop_project;

public class LanguageContext {
	private LanguageStrategy strategy;

    public LanguageContext(String language) {
        this.strategy = LanguageFactory.createLanguage(language);
    }

    public void setLanguage(String language) {
        this.strategy = LanguageFactory.createLanguage(language);
    }

    public String getTranslation(String key) {
        return strategy.getTranslation(key);
    }
	
}

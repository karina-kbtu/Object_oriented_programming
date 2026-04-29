package oop_project;
import java.util.List;
import java.util.ArrayList;
public class NewsPublisher {
    private List<Observer> observers = new ArrayList<>();
    private List<News> newsList = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void publishNews(News news) {
        newsList.add(news);
        notifyObservers(news);
    }

    private void notifyObservers(News news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public List<News> getPublishedNews() {
        return new ArrayList<>(newsList);
    }
}

package oop_project;

import java.util.Objects;

public class News {
    private String topic;
    private String content;
    private boolean pinned;

    public News(String topic, String content, boolean pinned) {
        this.topic = topic;
        this.content = content;
        this.pinned = pinned;
    }
    public String getTopic() {
        return topic;
    }
    public String getContent() {
        return content;
    }
    public boolean isPinned() {
        return pinned;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return topic.equals(news.topic) && content.equals(news.content);
    }
    public int hashCode() {
        return Objects.hash(topic, content);
    }

    public String toString() {
        return "News{" +
                "topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", pinned=" + pinned +
                '}';
    }
}

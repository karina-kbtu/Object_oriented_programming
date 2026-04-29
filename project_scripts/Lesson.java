package oop_project;

public class Lesson {
    private String topic;
    private LessonType type;

    public Lesson(String topic, LessonType type) {
        this.topic = topic;
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public LessonType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "topic='" + topic + '\'' +
                ", type=" + type +
                '}';
    }
}


package oop_project;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private String senderEmail;
    private String receiverEmail;
    private String content;
    private LocalDateTime timestamp;

    public Message(String senderEmail, String receiverEmail, String content) {
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
    public String getSenderEmail() {
        return senderEmail;
    }
    public String getReceiverEmail() {
        return receiverEmail;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getContent() {
    	return content;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(senderEmail, message.senderEmail) &&
                Objects.equals(receiverEmail, message.receiverEmail) &&
                Objects.equals(content, message.content);
    }
    public int hashCode() {
        return Objects.hash(senderEmail, receiverEmail, content);
    }
    public String toString() {
        return String.format("Message{sender='%s', receiver='%s', timestamp=%s, content='%s'}",
                senderEmail, receiverEmail, timestamp, content);
    }
    }
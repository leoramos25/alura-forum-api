package br.com.leords.forum.models;

import java.time.LocalDateTime;

public class Answer {
    
    private Long id;
    private String message;
    private Topic topic;
    private LocalDateTime createdAt;
    private User author;
    private Boolean solution = false;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Topic getTopic() {
        return topic;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public User getAuthor() {
        return author;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
    public Boolean getSolution() {
        return solution;
    }
    
    public void setSolution(Boolean solution) {
        this.solution = solution;
    }
}

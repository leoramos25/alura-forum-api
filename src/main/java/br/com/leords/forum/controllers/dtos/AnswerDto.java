package br.com.leords.forum.controllers.dtos;

import br.com.leords.forum.models.Answer;

import java.time.LocalDateTime;

public class AnswerDto {
    
    private Long id;
    private String message;
    private LocalDateTime createdAt;
    private String authorName;
    
    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.createdAt = answer.getCreatedAt();
        this.authorName = answer.getAuthor().getName();
    }
    
    public Long getId() {
        return id;
    }
    
    public String getMessage() {
        return message;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public String getAuthorName() {
        return authorName;
    }
}

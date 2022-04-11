package br.com.leords.forum.controllers.forms;

import br.com.leords.forum.models.Topic;
import br.com.leords.forum.repositories.CourseRepository;

public class TopicForm {
    
    private String title;
    private String message;
    private String courseName;
    
    public Topic formToModel(CourseRepository courseRepository) {
        return new Topic(
                title,
                message,
                courseRepository.findByName(courseName)
        );
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

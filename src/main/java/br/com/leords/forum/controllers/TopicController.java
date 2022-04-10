package br.com.leords.forum.controllers;

import br.com.leords.forum.controllers.dtos.TopicDto;
import br.com.leords.forum.models.Course;
import br.com.leords.forum.models.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    
    @GetMapping
    public List<TopicDto> listTopics() {
        Topic topic = new Topic("Dudida", "Duvida com spring boot", new Course("Spring", "Programação"));
        
        return TopicDto.modelToDto(Arrays.asList(topic, topic, topic));
    }
    
}

package br.com.leords.forum.controllers;

import br.com.leords.forum.controllers.dtos.TopicDto;
import br.com.leords.forum.repositories.TopicRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    
    private final TopicRepository topicRepository;
    
    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
    
    @GetMapping
    public List<TopicDto> listTopics() {
        return TopicDto.modelToDto(topicRepository.findAll());
    }
    
}

package br.com.leords.forum.controllers;

import br.com.leords.forum.controllers.dtos.DetailsTopicDto;
import br.com.leords.forum.controllers.dtos.TopicDto;
import br.com.leords.forum.controllers.forms.TopicForm;
import br.com.leords.forum.models.Topic;
import br.com.leords.forum.repositories.CourseRepository;
import br.com.leords.forum.repositories.TopicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    
    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;
    
    public TopicController(TopicRepository topicRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.courseRepository = courseRepository;
    }
    
    @GetMapping
    public List<TopicDto> listTopics(String courseName) {
        if (courseName == null) {
            return TopicDto.modelsToDtos(topicRepository.findAll());
        }
        return TopicDto.modelsToDtos(topicRepository.findByCourseName(courseName));
    }
    
    @PostMapping
    public ResponseEntity<TopicDto> createTopic(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.formToModel(courseRepository);
        topicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }
    
    @GetMapping(path = "/{id}")
    public DetailsTopicDto detailsTopic(@PathVariable("id") Long id) {
        return new DetailsTopicDto(topicRepository.getById(id));
    }
}
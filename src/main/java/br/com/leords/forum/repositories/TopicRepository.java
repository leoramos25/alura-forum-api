package br.com.leords.forum.repositories;

import br.com.leords.forum.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByCourseName(String courseName);
}

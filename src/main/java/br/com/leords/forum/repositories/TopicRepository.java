package br.com.leords.forum.repositories;

import br.com.leords.forum.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}

package org.example.simpletaskmanager.repository;

import org.example.simpletaskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<List<Task>> findAllByUserId(Long id);

}

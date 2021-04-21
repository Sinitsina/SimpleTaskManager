package org.example.simpletaskmanager.service;

import org.example.simpletaskmanager.dto.TaskDTO;
import org.example.simpletaskmanager.mapper.TaskMapper;
import org.example.simpletaskmanager.model.Task;
import org.example.simpletaskmanager.model.User;
import org.example.simpletaskmanager.repository.TaskRepository;
import org.example.simpletaskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private UserRepository userRepository;

    private TaskMapper taskMapper;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setTaskMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }


    /**
     * Find all books
     */
    public List<TaskDTO> findAllTasksByName(String name) {

        User user = userRepository.findByName(name).orElseThrow(
                ()->new IllegalArgumentException("User " + name + " was not found."));

        List<Task> result = taskRepository.findAllByUserId(user.getId()).orElseThrow(
                ()->new IllegalArgumentException("There aren't any tasks for user " + name));
        return taskMapper.taskListToDTOTaskList(result);

    }

}

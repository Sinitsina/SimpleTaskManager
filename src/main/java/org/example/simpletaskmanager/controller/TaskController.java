package org.example.simpletaskmanager.controller;

import org.example.simpletaskmanager.dto.TaskDTO;
import org.example.simpletaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all-tasks")
    public ResponseEntity<List<TaskDTO>> findAllTasks(@RequestParam(name = "name") String name) {

        return new ResponseEntity<>(taskService.findAllTasksByName(name), HttpStatus.OK);
    }
}

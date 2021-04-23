package org.example.simpletaskmanager.controller;

import org.example.simpletaskmanager.dto.TaskDTO;
import org.example.simpletaskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskControllerTest {

    @Mock
    TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    @Test
    void findAllTasksTest() {
        String name = "name";
        ResponseEntity<List<TaskDTO>> expected = mock(ResponseEntity.class);
        when(expected.getStatusCode()).thenReturn(HttpStatus.OK);
        ResponseEntity<List<TaskDTO>> actual = taskController.findAllTasks(name);
        assertEquals(expected.getStatusCode(), actual.getStatusCode());
    }
}

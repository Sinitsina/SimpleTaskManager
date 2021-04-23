package org.example.simpletaskmanager.controller;

import org.example.simpletaskmanager.dto.TaskDTO;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@Tag("IntegrationTest")
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = {"/data.sql"})
class TaskControllerIntegrationTest {

    @Autowired
    TaskController taskController;

    @Test
    void findAllTasksTest() {
        ResponseEntity<List<TaskDTO>> allTasks = taskController.findAllTasks("Иван");
        int expectedSize = 4;

        assertEquals(HttpStatus.OK, allTasks.getStatusCode());
        assertEquals(expectedSize, allTasks.getBody().size());
    }
}
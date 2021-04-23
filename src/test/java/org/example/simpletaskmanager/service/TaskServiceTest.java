package org.example.simpletaskmanager.service;

import org.example.simpletaskmanager.dto.TaskDTO;
import org.example.simpletaskmanager.mapper.TaskMapper;
import org.example.simpletaskmanager.model.Task;
import org.example.simpletaskmanager.model.User;
import org.example.simpletaskmanager.repository.TaskRepository;
import org.example.simpletaskmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TaskMapper taskMapper;

    @InjectMocks
    private TaskService taskService;

    @Test
    void findAllTasksByNameTest() {
        String name = "name";
        Long id = 1L;
        User userMock = mock(User.class);
        List<Task> taskListMock = mock(List.class);
        List<TaskDTO> expected = mock(List.class);
        when(userMock.getId()).thenReturn(id);
        when(userRepository.findByName(name)).thenReturn(Optional.of(userMock));
        when(taskRepository.findAllByUserId(id)).thenReturn(Optional.of(taskListMock));
        when(taskMapper.taskListToDTOTaskList(taskListMock)).thenReturn(expected);
        List<TaskDTO> actual = taskService.findAllTasksByName(name);
        assertEquals(expected, actual);
    }

    @Test
    void findAllTasksByNameTest2() {
        String name = "name";
        assertThrows(IllegalArgumentException.class, () -> taskService.findAllTasksByName(name));
    }

    @Test
    void findAllTasksByNameTest3() {
        String name = "name";
        Long id = 1L;
        User userMock = mock(User.class);
        when(userMock.getId()).thenReturn(id);
        when(userRepository.findByName(name)).thenReturn(Optional.of(userMock));
        assertThrows(IllegalArgumentException.class, () -> taskService.findAllTasksByName(name));
    }
}
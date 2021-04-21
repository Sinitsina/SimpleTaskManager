package org.example.simpletaskmanager.mapper;

import org.example.simpletaskmanager.dto.TaskDTO;
import org.example.simpletaskmanager.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task taskDTOToTask(TaskMapper taskMapper);

    List<TaskDTO> taskListToDTOTaskList(List<Task> tasks);
}

package org.example.simpletaskmanager.mapper;

import org.example.simpletaskmanager.dto.UserDTO;
import org.example.simpletaskmanager.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserMapper userMapper);
}

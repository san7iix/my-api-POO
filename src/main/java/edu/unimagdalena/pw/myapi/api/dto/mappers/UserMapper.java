package edu.unimagdalena.pw.myapi.api.dto.mappers;

import edu.unimagdalena.pw.myapi.api.dto.UserDTO;
import edu.unimagdalena.pw.myapi.entidades.User;

public class UserMapper {



    public UserDTO toDto(User user){
        UserDTO userDto = new UserDTO();

        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    public User toEntity(UserDTO userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());

        return user;
    }

}

package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.UserDTO;

import java.util.List;

public interface UsersService {

    UserDTO findById(Long id);

    List<UserDTO> findAll();

    UserDTO create(UserDTO user);

    UserDTO update(Long id, UserDTO user);

    UserDTO delete(Long id);


}

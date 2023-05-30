package edu.unimagdalena.pw.myapi.services;

import edu.unimagdalena.pw.myapi.api.dto.UserDTO;
import edu.unimagdalena.pw.myapi.api.dto.mappers.UserMapper;
import edu.unimagdalena.pw.myapi.entidades.User;
import edu.unimagdalena.pw.myapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(value -> new UserMapper().toDto(value)).orElse(null);

    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(value -> new UserMapper().toDto(value)).collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getEmail());

        if (userOptional.isPresent()) {
            return null;
        }

        User userEntity = new UserMapper().toEntity(user);

        return new UserMapper().toDto(userRepository.save(userEntity));
    }

    @Override
    public UserDTO update(Long id, UserDTO user) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty())
            return null;

        User userEntity = new UserMapper().toEntity(user);

        return new UserMapper().toDto(userRepository.save(userEntity));

    }

    @Override
    public UserDTO delete(Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty())
            return null;

        userRepository.deleteById(id);

        return new UserMapper().toDto(userOptional.get());

    }
}

package edu.unimagdalena.pw.myapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    Long id;

    String fullName;

    String email;

    String password;

}

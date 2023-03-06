package edu.unimagdalena.pw.myapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstudianteDto {
    
    private Long id;
    private String codigo;
    private String nombre;
    private String carrera;
    
}

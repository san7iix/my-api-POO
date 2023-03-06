package edu.unimagdalena.pw.myapi.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.unimagdalena.pw.myapi.api.dto.EstudianteDto;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {
    
    @GetMapping("/estudiantes") 
    public ResponseEntity<List<EstudianteDto>> getEstudiantes(@RequestParam(required = false) String carrera){
        List<EstudianteDto> estudiantesDB = new ArrayList<>();
        List<EstudianteDto> estudiantes = new ArrayList<>();
        Collections.addAll(estudiantesDB, 
            new EstudianteDto(1L,"20220214111", "Maria Jos'e", "Ing Sistemas"),
            new EstudianteDto(2L,"20200214001", "Ernesto Samper", "Ing Sistemas"),
            new EstudianteDto(3L,"20190114010", "Andrea TRo", "Ing Electronica"),
            new EstudianteDto(1L,"202102140101", "Eva Mar'ia", "Ing Sistemas"));
       if(carrera != null){
            estudiantes = estudiantesDB.stream().filter(e -> e.getCarrera().equals(carrera)).collect(Collectors.toList());
       }
        //return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteDto> createEstudiante(@RequestBody EstudianteDto estudiante){
        // ...
        return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
    }

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDto> updatedEstudiante(@RequestBody EstudianteDto estudiante, @PathVariable("id") Long id){

        return ResponseEntity.ok(estudiante);
    }

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<HttpStatus> deleteEstudiante(@PathVariable("id") Long id){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package edu.unimagdalena.pw.myapi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import edu.unimagdalena.pw.myapi.services.TeacherService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URI;

import edu.unimagdalena.pw.myapi.api.dto.TeacherCreationDto;
import edu.unimagdalena.pw.myapi.api.dto.TeacherDto;
import edu.unimagdalena.pw.myapi.api.dto.TeacherMapper;
import edu.unimagdalena.pw.myapi.entidades.Teacher;
@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;
    
    
    public TeacherController(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }
    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherCreationDto>> findAll(){
        List<Teacher> teachers = teacherService.findAll();
        List<TeacherCreationDto> teacherCreationDtos = teachers.stream()
                                                        .map(t -> teacherMapper.toTeacherCreationDto(t))
                                                        .collect(Collectors.toList());
                                                        
        return ResponseEntity.ok().body(teacherCreationDtos);
    }
    @GetMapping("/teachers/{id}")
    public ResponseEntity<TeacherCreationDto> find(@PathVariable("id") Long id){
        Optional<TeacherCreationDto> teacher = teacherService.find(id).map(t -> teacherMapper.toTeacherCreationDto(t));
        return ResponseEntity.of(teacher);
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherCreationDto> create(@RequestBody TeacherDto teacher){
        
        Teacher newTeacher = teacherMapper.toEntity(teacher);

        Teacher teacherCreated = teacherService.create(newTeacher);

        TeacherCreationDto teacherCreationDto = teacherMapper.toTeacherCreationDto(teacherCreated);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(teacherCreationDto.getId())
                        .toUri();

        return ResponseEntity.created(location).body(teacherCreationDto);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<TeacherCreationDto> update(@PathVariable("id") Long id, 
                                        @RequestBody TeacherCreationDto teacher
                                        ){

        Teacher teacherToUpdate = teacherMapper.toTeacherEntity(teacher) ;

        return teacherService.update(id, teacherToUpdate)        
            .map(teacherUpdated -> ResponseEntity.ok().body(teacherMapper.toTeacherCreationDto(teacherToUpdate)))
            .orElseGet(()->{
                Teacher teacherCreated = teacherService.create(teacherToUpdate);
                TeacherCreationDto teacherCreationDto = teacherMapper.toTeacherCreationDto(teacherToUpdate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(teacherCreationDto.getId())
                        .toUri();
        return ResponseEntity.created(location).body(teacherCreationDto);
            });
    }
}

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
import java.net.URI;

import edu.unimagdalena.pw.myapi.entidades.Teacher;
@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> findAll(){
        List<Teacher> teachers = teacherService.findAll();
        return ResponseEntity.ok().body(teachers);
    }
    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> find(@PathVariable("id") Long id){
        Optional<Teacher> teacher = teacherService.find(id);
        return ResponseEntity.of(teacher);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher){
        Teacher teacherCreated = teacherService.create(teacher);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(teacherCreated.getId())
                        .toUri();
        return ResponseEntity.created(location).body(teacherCreated);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> update(@PathVariable("id") Long id, 
                                        @RequestBody Teacher teacher
                                        ){
        return teacherService.update(id, teacher)
            .map(teacherUpdated -> ResponseEntity.ok().body(teacherUpdated))
            .orElseGet(()->{
                Teacher teacherCreated = teacherService.create(teacher);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(teacherCreated.getId())
                        .toUri();
        return ResponseEntity.created(location).body(teacherCreated);
            });
    }
}

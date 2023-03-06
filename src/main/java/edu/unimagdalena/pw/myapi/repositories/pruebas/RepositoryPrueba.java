package edu.unimagdalena.pw.myapi.repositories.pruebas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.unimagdalena.pw.myapi.entidades.Teacher;
import edu.unimagdalena.pw.myapi.repositories.TeacherRepository;
import edu.unimagdalena.pw.myapi.repositories.CourseRepository;
import edu.unimagdalena.pw.myapi.repositories.CourseMaterialRepository;
import edu.unimagdalena.pw.myapi.entidades.Course;
import edu.unimagdalena.pw.myapi.entidades.CourseMaterial;
@Component
public class RepositoryPrueba /*implements CommandLineRunner*/{
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final CourseMaterialRepository courseMaterialRepository;

    public RepositoryPrueba(TeacherRepository teacherRepository, CourseRepository courseRepository,
            CourseMaterialRepository courseMaterialRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.courseMaterialRepository = courseMaterialRepository;
    }

   // @Override
    public void run(String... args) throws Exception {
        

        teacherRepository.deleteAll();
        Teacher teacher1 = new Teacher(null, "Julian", "Pizarro", "20111140002", null);
        teacherRepository.save(teacher1);
        teacherRepository.save(new Teacher(null, "Maria", "Pertuz", "20111110003", null));
        teacherRepository.save(new Teacher(null, "Mauricio", "Luna", "20112110003", null));
        System.out.println("--------------------------------------");
        teacherRepository.findAll().stream().forEach(t-> System.out.println(t.getFirstName()));

        courseRepository.deleteAll();
        Course course1 = new Course(null, "PW", teacher1, null, null);
        courseRepository.save(course1);
        
        courseMaterialRepository.deleteAll();
        CourseMaterial cm1 = new CourseMaterial();
        cm1.setUrl("http://myurl.com"); 
        cm1.setCourse(course1);
        courseMaterialRepository.save(cm1);
        
    }   

    
}

package edu.unimagdalena.pw.myapi.services;
import java.util.List;
import java.util.Optional;
import edu.unimagdalena.pw.myapi.entidades.Course;
import edu.unimagdalena.pw.myapi.entidades.Student;
import edu.unimagdalena.pw.myapi.entidades.Teacher;
public interface CourseService {

    List<Course> findAll();
    Optional<Course> find(Long id);
    Course create(Course course);
    Optional<Course> update(Long id, Course newCourse);
    void delete(Long id);
    List<Course> findCourseByName(String name);
    Optional<Course> assignTeacher(Long id, Teacher teacher);
    Optional<Course> addStudent(Long idCourse, Student newStudent);
}

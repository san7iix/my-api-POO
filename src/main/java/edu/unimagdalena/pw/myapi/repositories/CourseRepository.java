package edu.unimagdalena.pw.myapi.repositories;
import org.springframework.data.jpa.repository.*;
import edu.unimagdalena.pw.myapi.entidades.Course;
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}

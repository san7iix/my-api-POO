package edu.unimagdalena.pw.myapi.repositories;
import org.springframework.data.jpa.repository.*;
import edu.unimagdalena.pw.myapi.entidades.Course;
import java.util.*;
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE c.name = ?1")
    List<Course> findByName(String name);
}

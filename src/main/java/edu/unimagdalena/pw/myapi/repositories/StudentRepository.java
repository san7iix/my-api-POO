package edu.unimagdalena.pw.myapi.repositories;
import org.springframework.data.jpa.repository.*;
import edu.unimagdalena.pw.myapi.entidades.Student;
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}

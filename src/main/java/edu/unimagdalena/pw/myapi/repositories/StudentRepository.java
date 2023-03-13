package edu.unimagdalena.pw.myapi.repositories;
import org.springframework.data.jpa.repository.*;
import edu.unimagdalena.pw.myapi.entidades.Student;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import edu.unimagdalena.pw.myapi.entidades.Gender;
public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByFirstNameStartingWith(String firname);
    Optional<Student> findByCodigo(String codigo);
    List<Student> findByBirthDateAndGender(LocalDate birthDate, Gender gender);

}

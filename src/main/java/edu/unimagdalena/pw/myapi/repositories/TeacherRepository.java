package edu.unimagdalena.pw.myapi.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.pw.myapi.entidades.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}

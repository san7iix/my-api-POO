package edu.unimagdalena.pw.myapi.repositories;
import org.springframework.data.jpa.repository.*;
import edu.unimagdalena.pw.myapi.entidades.CourseMaterial;
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long>{
    
}

package ma.ingecys.project.businessProcessManagement.repository;

import ma.ingecys.project.businessProcessManagement.bo.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
}

package gdsc.essential.repository;

import gdsc.essential.domain.SeminarDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeminarDateRepository extends JpaRepository<SeminarDate, Long> {
    Optional<SeminarDate> findByDate(String date);
}

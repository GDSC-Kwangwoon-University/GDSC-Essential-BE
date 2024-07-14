package gdsc.essential.repository;

import gdsc.essential.SeminarDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<SeminarDate, Long> {
}

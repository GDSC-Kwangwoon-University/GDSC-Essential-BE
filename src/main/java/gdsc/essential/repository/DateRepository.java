package gdsc.essential.repository;

import gdsc.essential.Entity.SeminarDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DateRepository extends JpaRepository<SeminarDate, Long> {
}

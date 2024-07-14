package gdsc.essential.repository;

import gdsc.essential.domain.SubmitInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EssentialRepository extends JpaRepository<SubmitInfo, Long> {
}

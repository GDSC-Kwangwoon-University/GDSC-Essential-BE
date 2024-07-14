package gdsc.essential;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
public class SeminarDate {
    private Long month_id;
    private LocalDate seminarDate;

    @Builder
    public SeminarDate(Long month_id, LocalDate seminarDate) {
        this.month_id = month_id;
        this.seminarDate = seminarDate;
    }
}

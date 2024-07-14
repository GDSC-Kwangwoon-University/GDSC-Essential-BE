package gdsc.essential.dto.response;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Setter
public class SeminarDatesResponseDTO {
    private LocalDate seminarDate;
}

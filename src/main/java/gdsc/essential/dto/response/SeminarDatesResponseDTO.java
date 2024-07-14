package gdsc.essential.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class SeminarDatesResponseDTO {
    private List<LocalDate> seminarDates;

    @Builder
    public SeminarDatesResponseDTO(List<LocalDate> seminarDates) {
        this.seminarDates = seminarDates;
    }
    public static SeminarDatesResponseDTO of(List<LocalDate> seminarDates){
        return SeminarDatesResponseDTO.builder()
                .seminarDates(seminarDates)
                .build();
    }
}

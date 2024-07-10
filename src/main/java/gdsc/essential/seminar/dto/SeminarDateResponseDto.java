package gdsc.essential.seminar.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SeminarDateResponseDto {
    private List<LocalDate> seminarDates;

    @Builder
    public SeminarDateResponseDto(List<LocalDate> seminarDates) {
        this.seminarDates = seminarDates;
    }

    public static SeminarDateResponseDto of(List<LocalDate> seminarDates){
        return SeminarDateResponseDto.builder()
                .seminarDates(seminarDates)
                .build();
    }


}

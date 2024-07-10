package gdsc.essential.seminar.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RecentSubmitDto {
    private LocalDate seminarDate;
    private String subject;
    private String content;


    @Builder
    public RecentSubmitDto(LocalDate seminarDate, String subject, String content) {
        this.seminarDate = seminarDate;
        this.subject = subject;
        this.content = content;
    }

    public RecentSubmitDto of(LocalDate seminarDate, String subject, String content) {
        return RecentSubmitDto.builder()
                .seminarDate(seminarDate)
                .subject(subject)
                .content(content)
                .build();
    }
}

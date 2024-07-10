package gdsc.essential.seminar;

import gdsc.essential.presentor.Presentor;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RecentSubmitSeminarInfo {

    private LocalDate seminarDate;
    private String subject;
    private String content;


    @Builder
    public RecentSubmitSeminarInfo(LocalDate seminarDate, String subject, String content) {
        this.seminarDate = seminarDate;
        this.subject = subject;
        this.content = content;
    }

    public static RecentSubmitSeminarInfo of(Seminar seminar, Presentor presentor) {
        return RecentSubmitSeminarInfo.builder()
                .seminarDate(seminar.getSeminarDate())
                .subject(presentor.getSubject())
                .content(presentor.getContent())
                .build();
    }




    public RecentSubmitSeminarInfo of(LocalDate seminarDate, String subject, String content) {
        return RecentSubmitSeminarInfo.builder()
                .seminarDate(seminarDate)
                .subject(subject)
                .content(content)
                .build();
    }
}

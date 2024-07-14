package gdsc.essential.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class Seminar {
    private LocalDate seminarDate;
    private List<Speaker> presenters;
    @Builder
    public Seminar(LocalDate seminarDate, List<Speaker> presenters) {
        this.seminarDate = seminarDate;
        this.presenters = presenters;
    }

    public void addPresenter(Speaker speaker){
        presenters.add(speaker);
    }
}

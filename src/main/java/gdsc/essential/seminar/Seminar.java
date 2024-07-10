package gdsc.essential.seminar;

import gdsc.essential.presentor.Presentor;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Seminar {

    private LocalDate seminarDate;
    private List<Presentor> presentorList;

    @Builder
    public Seminar(LocalDate seminarDate, List<Presentor> presentorList) {
        this.seminarDate = seminarDate;
        this.presentorList = presentorList;
    }

    public void addPresentor(Presentor presentor){
        presentorList.add(presentor);
    }
}

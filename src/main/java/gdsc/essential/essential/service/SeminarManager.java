package gdsc.essential.essential.service;

import gdsc.essential.presentor.Presentor;
import gdsc.essential.seminar.RecentSubmitSeminarInfo;
import gdsc.essential.seminar.Seminar;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SeminarManager {

    void addSeminar(Seminar seminar);

    Optional<Seminar> findSeminarByDate(LocalDate seminarDate);

     List<LocalDate> extractAllSeminarDate();

    void updateRecentRequestSeminar(Seminar seminarByDate, Presentor presentor);

    void addSeminarDate(LocalDate localDate);

    RecentSubmitSeminarInfo getRecentRequestSeminar();
}

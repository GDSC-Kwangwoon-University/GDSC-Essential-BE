package gdsc.essential.essential.controller;

import gdsc.essential.seminar.RecentSubmitSeminarInfo;
import gdsc.essential.seminar.dto.SubmitRequestDto;
import java.time.LocalDate;
import java.util.List;

public interface EssentialService {

    void addPresentor(SubmitRequestDto submitRequestDto);

    List<LocalDate> exractSeminarDates();

    RecentSubmitSeminarInfo recentSeminarRequest();

    void addSeminarDate(LocalDate localDate);
}

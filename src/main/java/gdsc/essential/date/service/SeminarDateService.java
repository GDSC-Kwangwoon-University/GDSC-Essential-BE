package gdsc.essential.date.service;

import java.util.List;

public interface SeminarDateService {
    //세미나 날짜 등록
    void postSeminarDates(List<String> dates);
    //세미나 날짜 조회
    List<String> getSeminarDates();
    //가능한 날짜인지 조회
    boolean isDateAvailable(String date);
}

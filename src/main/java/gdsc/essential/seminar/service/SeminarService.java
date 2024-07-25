package gdsc.essential.seminar.service;

import gdsc.essential.seminar.model.Seminar;

public interface SeminarService {
    //세미나 신청 작성
    void postSeminar(Seminar seminar);
    //최근 세미나 신청 가져오기
    Seminar getLastSeminar();

}

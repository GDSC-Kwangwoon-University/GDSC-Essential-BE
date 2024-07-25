package gdsc.essential.seminar.service;

import gdsc.essential.seminar.model.Seminar;
import gdsc.essential.date.service.SeminarDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeminarServiceImpl implements SeminarService {
    private final SeminarDateService seminarDateService;
    private Seminar lastSeminar;

    @Autowired
    public SeminarServiceImpl(SeminarDateService seminarDateService) {
        this.seminarDateService = seminarDateService;
    }

    @Override
    public void postSeminar(Seminar seminar) {
        if (seminarDateService.isDateAvailable(seminar.getSeminarDate().toString())) {
            lastSeminar = seminar;
        } else {
            throw new IllegalArgumentException("해당 날짜에는 세미나를 신청할 수 없습니다.");
        }
    }

    @Override
    public Seminar getLastSeminar() {
        return lastSeminar;
    }
}

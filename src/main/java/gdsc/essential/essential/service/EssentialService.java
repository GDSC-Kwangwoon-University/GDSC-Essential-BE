package gdsc.essential.essential.service;

import gdsc.essential.presentor.Presentor;
import gdsc.essential.seminar.RecentSubmitSeminarInfo;
import gdsc.essential.seminar.Seminar;
import gdsc.essential.seminar.dto.SubmitRequestDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EssentialService {

    private final SeminarManager seminarManager;

    public void addPresentor(SubmitRequestDto submitRequestDto) {
        Optional<Seminar> seminarByDate = seminarManager.findSeminarByDate(
            submitRequestDto.getSeminarDate());
        if(seminarByDate.isEmpty()){
            throw new IllegalArgumentException("해당 세미나가 존재하지 않습니다.");
        }

        Seminar seminar = seminarByDate.get();
        Presentor presentor = Presentor.of(submitRequestDto.getContent(), submitRequestDto.getSubject());

        seminar.addPresentor(presentor);
        seminarManager.updateRecentRequestSeminar(seminar, presentor);
    }


    public List<LocalDate> exractSeminarDates() {
        return seminarManager.extractAllSeminarDate();
    }


    public RecentSubmitSeminarInfo recentSeminarRequest(){
        return seminarManager.getRecentRequestSeminar();
    }

    public void addSeminarDate(LocalDate localDate) {
        seminarManager.addSeminarDate(localDate);
    }
}

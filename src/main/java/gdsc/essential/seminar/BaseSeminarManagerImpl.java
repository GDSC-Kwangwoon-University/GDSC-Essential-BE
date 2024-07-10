package gdsc.essential.seminar;

import gdsc.essential.presentor.Presentor;
import gdsc.essential.essential.service.SeminarManager;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BaseSeminarManagerImpl implements SeminarManager {

    private List<Seminar> seminars;
    private RecentSubmitSeminarInfo recentSubmitSeminarInfo;


    @PostConstruct
    public void init(){
        seminars = new ArrayList<>(Arrays.asList(
            Seminar.builder()
                .seminarDate(LocalDate.of(2021, 10, 1))
                .presentorList(new ArrayList<>())
                .build(),
            Seminar.builder()
                .seminarDate(LocalDate.of(2024, 8, 22))
                .presentorList(new ArrayList<>())
                .build()
        ));
    }

    @Override
    public void addSeminar(Seminar seminar) {
        seminars.add(seminar);
    }

    @Override
    public Optional<Seminar> findSeminarByDate(LocalDate seminarDate) {
        return seminars.stream()
            .filter(seminar -> seminar.getSeminarDate().equals(seminarDate))
            .findFirst();
    }

    @Override
    public List<LocalDate> extractAllSeminarDate() {
        return seminars.stream().
            map(Seminar::getSeminarDate)
            .toList();
    }

    @Override
    public void updateRecentRequestSeminar(Seminar requestSeminar, Presentor presentor) {
        recentSubmitSeminarInfo = RecentSubmitSeminarInfo.of(requestSeminar, presentor);
    }

    @Override
    public void addSeminarDate(LocalDate localDate) {
        seminars.add(Seminar.builder()
            .seminarDate(localDate)
            .presentorList(new ArrayList<>())
            .build());
    }

    @Override
    public RecentSubmitSeminarInfo getRecentRequestSeminar() {
        return recentSubmitSeminarInfo;
    }
}


